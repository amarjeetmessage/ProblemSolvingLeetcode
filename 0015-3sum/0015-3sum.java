class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        for(int i = 0; i < n; i++){

            // skip duplicate i
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int j = i + 1;
            int k = n - 1;

            while(j < k){
                int total = nums[i] + nums[j] + nums[k];

                if(total == 0){
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    // skip duplicate j
                    while(j < k && nums[j] == nums[j-1]) j++;

                    // skip duplicate k
                    while(j < k && nums[k] == nums[k+1]) k--;
                }
                else if(total > 0){
                    k--;
                } 
                else{
                    j++;
                }
            }
        }
        return list;
    }
}