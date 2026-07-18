class Solution {
    public int findGCD(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int start = nums[0];
        for(int i =start ; i>0; i--){
            if(nums[0] % i == 0 && nums[n-1] % i == 0){
                return i;
            }
        }
        return -1;
    }
}