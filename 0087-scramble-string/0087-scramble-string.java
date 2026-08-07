import java.util.*;

class Solution {

    boolean isScrambleString(String s1, String s2, HashMap<String, Boolean> dp) {

        if (s1.equals(s2))
            return true;

        String key = s1 + "#" + s2;

        if (dp.containsKey(key))
            return dp.get(key);

        int n = s1.length();

        int[] freq = new int[26];

        for (int i = 0; i < n; i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }

        for (int count : freq) {
            if (count != 0) {
                dp.put(key, false);
                return false;
            }
        }

        // Try every possible split
        for (int i = 1; i < n; i++) {

            // Without swap
            boolean noSwap =
                    isScrambleString(s1.substring(0, i), s2.substring(0, i), dp)
                    && isScrambleString(s1.substring(i), s2.substring(i), dp);

            if (noSwap) {
                dp.put(key, true);
                return true;
            }

            // With swap
            boolean swap =
                    isScrambleString(s1.substring(0, i), s2.substring(n - i), dp)
                    && isScrambleString(s1.substring(i), s2.substring(0, n - i), dp);

            if (swap) {
                dp.put(key, true);
                return true;
            }
        }

        dp.put(key, false);
        return false;
    }

    public boolean isScramble(String s1, String s2) {

        if (s1.length() != s2.length())
            return false;

        HashMap<String, Boolean> dp = new HashMap<>();

        return isScrambleString(s1, s2, dp);
    }
}