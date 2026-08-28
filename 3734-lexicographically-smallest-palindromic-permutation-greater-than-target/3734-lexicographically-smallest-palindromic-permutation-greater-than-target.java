class Solution {

    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();

        int[] freq = new int[26];

        // Count frequencies
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Find middle character and check palindrome possibility
        int oddCount = 0;
        char middle = 0;

        for (int i = 0; i < 26; i++) {

            if (freq[i] % 2 == 1) {
                oddCount++;
                middle = (char) ('a' + i);
            }
        }

        // Cannot form palindrome
        if (oddCount > 1) {
            return "";
        }

        // Frequency of left half
        int[] halfFreq = new int[26];

        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
        }

        int halfLen = n / 2;

        // Build target's left half if possible
        StringBuilder prefix = new StringBuilder();

        int matched = 0;

        while (matched < halfLen) {

            char ch = target.charAt(matched);

            if (halfFreq[ch - 'a'] == 0) {
                break;
            }

            prefix.append(ch);
            halfFreq[ch - 'a']--;
            matched++;
        }

        // CASE 1:
        // Entire left half of target was available
        if (matched == halfLen) {

            String candidate = buildPalindrome(prefix.toString(), middle, n);

            // Strictly greater
            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        // CASE 2:
        // Need to make some position greater.
        // Try from right to left.
        for (int i = matched; i >= 0; i--) {

            if (i < matched) {
                // Restore character used at position i
                halfFreq[target.charAt(i) - 'a']++;
            }

            // No position exists when i == halfLen
            if (i == halfLen) {
                continue;
            }

            // Find smallest available character > target[i]
            for (int c = target.charAt(i) - 'a' + 1;
                 c < 26;
                 c++) {

                if (halfFreq[c] > 0) {

                    StringBuilder left = new StringBuilder();

                    // Keep prefix same
                    left.append(target.substring(0, i));

                    // Put greater character
                    left.append((char) ('a' + c));

                    halfFreq[c]--;

                    // Fill remaining characters in sorted order
                    for (int j = 0; j < 26; j++) {
                        while (halfFreq[j] > 0) {
                            left.append((char) ('a' + j));
                            halfFreq[j]--;
                        }
                    }

                    return buildPalindrome(
                        left.toString(),
                        middle,
                        n
                    );
                }
            }
        }

        return "";
    }


    private String buildPalindrome(
            String left,
            char middle,
            int n
    ) {

        StringBuilder ans = new StringBuilder();

        // Left half
        ans.append(left);

        // Middle character (only for odd length)
        if (n % 2 == 1) {
            ans.append(middle);
        }

        // Right half = reverse of left
        ans.append(new StringBuilder(left).reverse());

        return ans.toString();
    }
}//potd