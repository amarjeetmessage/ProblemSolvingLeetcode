class Solution {
    public int minIncrementForUnique(int[] nums) {
        // apply greedy algo 
        
        // sort the number 
        // we have to find if duplicates then nearest possible to make unique

        int n = nums.length;
        Arrays.sort(nums);
        int expected = nums[0];
        int moves = 0;

        for(int i = 1; i<n; i++){
            if(nums[i] >= expected+1){
                expected = nums[i];
            }else{
                expected++;
                moves = moves + expected- nums[i];
            }
        }

        return moves;
    }
}