class Solution {
    public int maxActiveSectionsAfterTrade(String s) {

        int ones = 0;
        int maxGain = 0;

        // Length of previous zero group
        int prevZero = Integer.MIN_VALUE;

        int i = 0;
        int n = s.length();

        while (i < n) {

            int j = i;

            // Find current consecutive block
            while (j < n && s.charAt(j) == s.charAt(i))
                j++;

            int len = j - i;

            if (s.charAt(i) == '1') {
                ones += len;
            } else {
                maxGain = Math.max(maxGain, prevZero + len);
                prevZero = len;
            }

            i = j;
        }

        return ones + maxGain;
    }
}