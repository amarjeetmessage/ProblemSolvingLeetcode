class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;

        if(n == 1) return true;
        
        int even = 0, odd = 0;

        int min = Integer.MAX_VALUE;
        for(int num : nums1) {
            if(num % 2 == 0) even++;
            else odd++;

            min = Math.min(min,num);
        }
        boolean allEven = (even== n || (odd>=2 && min % 2 == 1));
        boolean allOdd = (odd >= 1 && even >= 1 && (min % 2 == 1));

        // boolean allOdd = false;
        // if(odd >=1 && even >= 1) {
        //     if(min % 2 == 1) {
        //         allOdd = true;
        //     }
        // }
        return allEven || allOdd;
    }
}