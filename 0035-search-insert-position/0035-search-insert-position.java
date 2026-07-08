// class Solution {
//     public int searchInsert(int[] nums, int target) {
//         int n = nums.length;
//         if(nums[0] > target){
//             return 0;
//         }
//         if(nums[n-1] < target) return n;

//         for(int i = 0; i<n; i++){
//             if(nums[i] == target) return i;

//             if(nums[i]< target && nums[i+1] > target){
//                 return i+1;
//             }
//         }
//         return -1;
//     }
// }



class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        
        int low = 0;
        int high = n-1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid] < target){
                low = mid+1;
            }else{
                high = mid - 1;
            }
        }
        return low ;
    }
}