// class Solution {
//     public int firstMissingPositive(int[] nums) {
//         int n = nums.length;
//         Set<Integer> set = new HashSet<>();
//         for(int num : nums) {
//             set.add(num);
//         }

//         for(int i = 1; i<=n; i++){
//             if(!set.contains(i)){
//                 return i;
//             }
//         }
//         return n+1;
//     }
// }



// SOLVING USING CYCLIC SORT IS BEST
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;

        while(i<n){
            int correctIdx = nums[i] -1;

            if(correctIdx < 0 || correctIdx >= n){
                i = i+1;
            }
            else if(nums[correctIdx] != nums[i]){
                int temp = nums[correctIdx];
                nums[correctIdx] = nums[i];
                nums[i] = temp;
            }else{
                i = i+1;
            }
        }

        // sorted now traverse array to find missing
        for(i = 0; i<n; i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return i+1;
        
    }
}

