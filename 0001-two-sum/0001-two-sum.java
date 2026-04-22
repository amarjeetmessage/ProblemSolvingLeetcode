class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int i = 0;
        int j = n-1;
        int[] ans = new int[2];

        while(i<j){
            int sum = nums[i] + nums[j];
            if(sum == target){
                ans[0] = i;
                ans[1] = j;
            }
            if(sum > target){
                j--;
            }
            else{
                i++;
            }
        }
        return ans;
    }
}