class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // create ArrayList
        ArrayList<Integer> list = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 2){
                list.add(entry.getKey());
            }
        }
        return list;
    }
}