class Solution {
    public int search(int[] nums, int target) {
      //apply binary search 
      int n = nums.length;
      int left = 0;
      int right = n-1;

      while(left <= right){
        int mid = (left + right) / 2;

        if(nums[mid] == target){
            return mid;
        }
        else if(nums[mid] > target){
            right = mid-1;
        }else{
            left = mid+1;
        }
      } 
      return -1; 
    }
}


// class Solution {
//     public int search(int[] nums, int target) {
//         int len = nums.length;
//         for(int i = 0; i<len; i++) {
//             if(nums[i] == target) {
//                 return i;
//             }
//         }
//         return -1;
//     }
// }


// class Solution {
//     public int search(int[] nums, int target) {
//         int low = 0;
//         int high = nums.length - 1;

//         while (low <= high) {
//             int mid = low + (high - low) / 2;

//             if (nums[mid] == target) {
//                 return mid;
//             } 
//             else if (nums[mid] < target) {
//                 low = mid + 1;
//             } 
//             else {
//                 high = mid - 1;
//             }
//         }

//         return -1;
//     }
// }