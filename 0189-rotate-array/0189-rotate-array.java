// class Solution {
//     public void rotate(int[] nums, int k) {

//         // brute force approach
//         int n = nums.length;
//         k = k %n;

//         while(k-- > 0){
//             int lastdigit = nums[n-1];

//             for(int i = n-1; i > 0; i--){
//                 nums[i] = nums[i-1];
//             }

//             nums[0] = lastdigit;
//         }
//     }
// }








class Solution {

    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k %= n;

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[(i + k) % n] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = ans[i];
        }
    }
}