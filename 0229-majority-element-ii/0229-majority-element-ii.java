class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        int count = n/3;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // Check which elements appear more than n/3 times
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > count){
                result.add(entry.getKey());
            }
        }

        return result;
    }
}