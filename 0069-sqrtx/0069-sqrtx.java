// class Solution {
//     public int mySqrt(int x) {
//         return (int)Math.sqrt(x);

//     }
// }

// class Solution {
//     public int mySqrt(int x) {
//         if(x == 2147483647) return 46340;
//         for(int i = 0; i< (x/2) + 2; i++){
//             if(i*i == x){
//                 return i;
//             }
//             else if(i*i > x){
//                 return i-1;
//             }
//         }
//         return -1;
//     }
// }







// class Solution {
//     public int mySqrt(int x) {
//         // if(x == 2147483647) return 46340;
//         for(long i = 0; i< (x/2) + 2; i++){
//             if(i*i == x){
//                 return (int)i;
//             }
//             else if(i*i > x){
//                 return (int)(i-1);
//             }
//         }
//         return -1;
//     }
// }




class Solution {
    public int mySqrt(int x) {
        int ans = 0;
        for(int i = 0; i<=x; i++){
            long val = (long) i*i;

            if(val > x){
                break;
            }

            ans = i;
        }

        return ans;
    }
}





// //Using Binary Search 
// class Solution {
//     public int mySqrt(int x) {
//         if (x == 0 || x == 1) return x;

//         int left = 1, right = x;
//         int ans = 0;

//         while (left <= right) {
//             int mid = left + (right - left) / 2;

//             if (mid <= x / mid) {
//                 ans = mid;        // possible answer
//                 left = mid + 1;   // try bigger
//             } else {
//                 right = mid - 1;  // go smaller
//             }
//         }

//         return ans;
//     }
// }