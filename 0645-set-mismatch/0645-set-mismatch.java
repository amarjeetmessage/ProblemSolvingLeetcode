// class Solution {
//     public int[] findErrorNums(int[] nums) {

//         Arrays.sort(nums);

//         int duplicate = -1;
//         int missing = 1; // if write -1 then need to handled the first missing in last as last is handled 

//         for (int i = 1; i < nums.length; i++) {

//             if (nums[i] == nums[i - 1]) {
//                 duplicate = nums[i];
//             }
//             else if (nums[i] > nums[i - 1] + 1) {
//                 missing = nums[i - 1] + 1;
//             }
//         }

//         // If missing number is n
//         if (nums[nums.length - 1] != nums.length)
//             missing = nums.length;

//         return new int[]{duplicate, missing};
//     }
// }




//solving using cyclic sort in tc = O(n) and sc = O(1)
class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int i = 0; 

        while(i < n) {
            int correctIdx = nums[i] - 1;
            if(nums[correctIdx] != nums[i]){
                //swap
                int temp = nums[correctIdx];
                nums[correctIdx] = nums[i];
                nums[i] = temp;
            }else{
                i = i+1;
            }
        }

        for(i = 0; i<n; i++){
            if(nums[i] != i+1){
                int missing = i+1;
                int duplicate = nums[i];
                return new int[]{duplicate, missing};
            }
        }
        return new int[]{-1,-1};
    }
}