class Solution {
    //POTD
    public int nextBeautifulNumber(int n) {
        for (int i = n + 1; ; i++) {
            if (isBalanced(i)) return i;
        }
    }

    private boolean isBalanced(int num) {
        String s = String.valueOf(num);
        int[] count = new int[10];

        // Count each digit
        for (char c : s.toCharArray()) {
            count[c - '0']++;
        }

        // Check balance condition
        for (char c : s.toCharArray()) {
            int d = c - '0';
            if (count[d] != d) return false;
        }

        return true;
    }
}
