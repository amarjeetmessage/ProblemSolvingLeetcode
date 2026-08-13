class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n == 1) return true;
        int idx = 0;
        for(int i = 0; i<n-1; i++){
            if(i > idx) return false;
            idx = Math.max(idx, i + nums[i]);
        }

        return idx>=n-1;
    }
}




// class Solution {
//     public boolean canJump(int[] nums) {

//         int maxi = 0;
//         int n = nums.length;

//         for(int i = 0; i < nums.length; i++){
//             maxi = Math.max(maxi, i + nums[i]);

//             if(maxi == n - 1) break;

//             if(i == maxi) return false;
//         }

//         return true;
//     }
// }