//OPTIMAL APPROACH

// class Solution {
//     public void rotate(int[] nums, int k) {
//         int n = nums.length;
//         k = k % n; // Normalize k

//         // Helper method to reverse part of the array
//         reverse(nums, 0, n - 1);      // Step 1: Reverse whole array
//         reverse(nums, 0, k - 1);      // Step 2: Reverse first k elements
//         reverse(nums, k, n - 1);      // Step 3: Reverse the rest
//     }

//     private void reverse(int[] nums, int start, int end) {
//         while (start < end) {
//             int temp = nums[start];
//             nums[start] = nums[end];
//             nums[end] = temp;
//             start++;
//             end--;
//         }
//     }
// }



//better approach
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }
    
}
