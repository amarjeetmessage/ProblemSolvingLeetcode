// class Solution {
//     public int minEatingSpeed(int[] piles, int h) {
//         // you can solve using brute force and binary search 
//         // i understood this 

//         // condtions are  
//         // 1. min speed is 1 and max speed is max element of piles
//         // 2. koko can not eat in two diff piles in one hour

        
//     }
// }

// class Solution {
//     public int minEatingSpeed(int[] piles, int h) {

//         int max = 0;

//         // Find maximum pile
//         for (int pile : piles) {
//             max = Math.max(max, pile);
//         }

//         // Try every possible speed
//         for (int speed = 1; speed <= max; speed++) {

//             long hours = 0;

//             // Calculate hours required at this speed
//             for (int pile : piles) {
//                 hours += (pile + speed - 1) / speed;
//             }

//             // If Koko can finish within h hours
//             if (hours <= h) {
//                 return speed;
//             }
//         }

//         return -1;
//     }
// }






class Solution {

    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = 0;

        // Find maximum pile
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long hours = 0;

            // Calculate total hours needed at speed = mid
            for (int pile : piles) {
                hours += (pile + mid - 1) / mid;
            }

            if (hours <= h) {
                ans = mid;      // Current speed works
                high = mid - 1; // Try a smaller speed
            } else {
                low = mid + 1;  // Need a faster speed
            }
        }

        return ans;
    }
}