class Solution {
    public String largestNumber(int[] nums) {
        
        String[] arr = new String[nums.length];
        
        // Step 1: convert to string
        for(int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        
        // Step 2: custom sort
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        
        // Step 3: edge case (all zeros)
        if(arr[0].equals("0")) return "0";
        
        // Step 4: build result
        StringBuilder sb = new StringBuilder();
        for(String s : arr) {
            sb.append(s);
        }
        
        return sb.toString();
    }
}