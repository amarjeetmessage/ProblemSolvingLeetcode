class Solution {
    public int longestPalindrome(String s) {
        // Set to track characters with odd frequency
        HashSet<Character> set = new HashSet<>();
        int length = 0;

        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) {
                // Pair found: remove and add 2 to length
                set.remove(ch);
                length += 2;
            } else {
                // First occurrence: add to set
                set.add(ch);
            }
        }

        // If there's any unpaired character left, we can place 1 in center
        if (!set.isEmpty()) {
            length += 1;
        }

        return length;
    }
}
