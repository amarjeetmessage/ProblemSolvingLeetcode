// class Solution {
//     public int removeDuplicates(int[] nums) {
//         int unique = 1;
//         for(int i=1; i<nums.length; i++){
//             if(nums[i] != nums[i-1]) {
//                 unique++;
//                 nums[unique -1 ] = nums[i];
//             }
//         }return unique;
//     }
// }

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0;  // Slow pointer

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;  // Number of unique elements
    }
}


