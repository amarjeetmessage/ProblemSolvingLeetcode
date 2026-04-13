class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<nums.length; i++){
            sb.append(nums[i]);
        }

        char target = (char)(digit + '0');
        int count = 0;
        for(int i = 0; i<sb.length(); i++) {
            if(sb.charAt(i) == target) {
                count++;
            }
        }
        return count;
    }
}