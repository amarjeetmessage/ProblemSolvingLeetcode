class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) return result;

        int start = nums[0]; // start of current range

        for (int i = 1; i <= nums.length; i++) {
            // if end of array OR sequence breaks
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    result.add(String.valueOf(start)); // single element
                } else {
                    result.add(start + "->" + nums[i - 1]); // range
                }
                // update new start if not finished
                if (i < nums.length) start = nums[i];
            }
        }

        return result;
    }
}
