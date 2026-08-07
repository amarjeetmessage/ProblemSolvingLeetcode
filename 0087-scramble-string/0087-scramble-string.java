// import java.util.*;

// class Solution {

//     boolean isScrambleString(String s1, String s2, HashMap<String, Boolean> dp) {

//         if (s1.equals(s2))
//             return true;

//         String key = s1 + "#" + s2;

//         if (dp.containsKey(key))
//             return dp.get(key);

//         int n = s1.length();

//         int[] freq = new int[26];

//         for (int i = 0; i < n; i++) {
//             freq[s1.charAt(i) - 'a']++;
//             freq[s2.charAt(i) - 'a']--;
//         }

//         for (int count : freq) {
//             if (count != 0) {
//                 dp.put(key, false);
//                 return false;
//             }
//         }

//         // Try every possible split
//         for (int i = 1; i < n; i++) {

//             // Without swap
//             boolean noSwap =
//                     isScrambleString(s1.substring(0, i), s2.substring(0, i), dp)
//                     && isScrambleString(s1.substring(i), s2.substring(i), dp);

//             if (noSwap) {
//                 dp.put(key, true);
//                 return true;
//             }

//             // With swap
//             boolean swap =
//                     isScrambleString(s1.substring(0, i), s2.substring(n - i), dp)
//                     && isScrambleString(s1.substring(i), s2.substring(0, n - i), dp);

//             if (swap) {
//                 dp.put(key, true);
//                 return true;
//             }
//         }

//         dp.put(key, false);
//         return false;
//     }

//     public boolean isScramble(String s1, String s2) {

//         if (s1.length() != s2.length())
//             return false;

//         HashMap<String, Boolean> dp = new HashMap<>();

//         return isScrambleString(s1, s2, dp);
//     }
// }







// class Solution {

//     boolean isScrambleString(String s1, String s2) {

//         if (s1.equals(s2))
//             return true;

//         int n = s1.length();

//         int[] freq = new int[26];

//         for (int i = 0; i < n; i++) {
//             freq[s1.charAt(i) - 'a']++;
//             freq[s2.charAt(i) - 'a']--;
//         }

//         for (int count : freq) {
//             if (count != 0)
//                 return false;
//         }

//         // Try every possible split
//         for (int i = 1; i < n; i++) {

//             // No Swap
//             boolean noSwap =
//                     isScrambleString(s1.substring(0, i), s2.substring(0, i))
//                     && isScrambleString(s1.substring(i), s2.substring(i));

//             if (noSwap)
//                 return true;

//             // Swap
//             boolean swap =
//                     isScrambleString(s1.substring(0, i), s2.substring(n - i))
//                     && isScrambleString(s1.substring(i), s2.substring(0, n - i));

//             if (swap)
//                 return true;
//         }

//         return false;
//     }

//     public boolean isScramble(String s1, String s2) {

//         if (s1.length() != s2.length())
//             return false;

//         return isScrambleString(s1, s2);
//     }
// }








class Solution {

    boolean isMatch(int start1, int end1,
                    int start2, int end2,
                    String s1, String s2,
                    int[][][][] dp) {

        if (start1 == end1) {
            return s1.charAt(start1) == s2.charAt(start2);
        }

        if (dp[start1][end1][start2][end2] != -1) {
            return dp[start1][end1][start2][end2] == 1;
        }

        // Frequency check
        int[] freq = new int[26];

        for (int i = start1; i <= end1; i++) {
            freq[s1.charAt(i) - 'a']++;
        }

        for (int i = start2; i <= end2; i++) {
            freq[s2.charAt(i) - 'a']--;
        }

        for (int count : freq) {
            if (count != 0) {
                dp[start1][end1][start2][end2] = 0;
                return false;
            }
        }

        int size = end1 - start1 + 1;

        for (int len = 0; len < size - 1; len++) {

            // No Swap
            boolean noSwap =
                    isMatch(start1, start1 + len,
                            start2, start2 + len,
                            s1, s2, dp)
                    &&
                    isMatch(start1 + len + 1, end1,
                            start2 + len + 1, end2,
                            s1, s2, dp);

            if (noSwap) {
                dp[start1][end1][start2][end2] = 1;
                return true;
            }

            // Swap
            boolean swap =
                    isMatch(start1, start1 + len,
                            end2 - len, end2,
                            s1, s2, dp)
                    &&
                    isMatch(start1 + len + 1, end1,
                            start2, end2 - len - 1,
                            s1, s2, dp);

            if (swap) {
                dp[start1][end1][start2][end2] = 1;
                return true;
            }
        }

        dp[start1][end1][start2][end2] = 0;
        return false;
    }

    public boolean isScramble(String s1, String s2) {

        int n = s1.length();

        int[][][][] dp = new int[31][31][31][31];

        for (int i = 0; i < 31; i++) {
            for (int j = 0; j < 31; j++) {
                for (int k = 0; k < 31; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }

        return isMatch(0, n - 1, 0, n - 1, s1, s2, dp);
    }
}