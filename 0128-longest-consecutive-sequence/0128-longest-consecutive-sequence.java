class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i<n; i++){
            set.add(nums[i]);
        }

        int longest = 0;
        for(int num : set) {
            // it may be starting point
            if(!set.contains(num -1)){
                int current = num;
                int length =1;

                while(set.contains(current+1)){
                    length++;
                    current++;
                }

                longest = Math.max(longest, length);
            }
        }
        return longest; 
    }
}