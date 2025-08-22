class Solution {
    public String kthDistinct(String[] arr, int k) {
        // Step 1: Count frequency of each string
        Map<String, Integer> freq = new HashMap<>();
        for (String s : arr) {
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        }

        // Step 2: Traverse in order to find kth distinct
        int count = 0;
        for (String s : arr) {
            if (freq.get(s) == 1) {  // distinct string
                count++;
                if (count == k) {
                    return s;
                }
            }
        }

        // Step 3: If fewer than k distinct strings exist
        return "";
    }
}
