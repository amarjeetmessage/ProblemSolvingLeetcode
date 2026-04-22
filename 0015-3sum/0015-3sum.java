class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int target = 0;
        int n = nums.length;
        Arrays.sort(nums);

        for(int i = 0; i<n; i++){
            int sum = nums[i];

            int j = i+1;
            int k = n-1;

            while(j<k){
                if(sum + nums[j] + nums[k] == target){
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
                if(nums[j] + nums[k] > target - sum){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return list;
    }
}
