// // size of wordA must be exactly one less than the wordB 
// // need to first sort on size 

// public class Solution {
//     public boolean isPredecessor(String word1, String word2) {
//         if (word1.length() + 1 != word2.length()) {
//             return false;
//         }

//         int i = word1.length() - 1;
//         int j = word2.length() - 1;

//         while (i >= 0 && j >= 0) {
//             if (word1.charAt(i) == word2.charAt(j)) {
//                 i--;
//                 j--;
//             } else {
//                 j--;
//             }
//         }

//         return i < 0;
//     }

//     public int longestStrChain(String[] words) {
//         // sorting on the basis of word length
//         Arrays.sort(words, (a, b) -> a.length() - b.length());
//         int n = words.length;
//         int[] LCS = new int[n];
//         Arrays.fill(LCS, 1);
//         int maxLength = 1;
//         for (int i = 1; i < n; i++) {
//             for (int j = i - 1; j >= 0; j--) {
//                 if (isPredecessor(words[j], words[i])) {
//                     LCS[i] = Math.max(LCS[i], 1 + LCS[j]);
//                 }
//             }

//             maxLength = Math.max(maxLength, LCS[i]);
//         }

//         return maxLength;
//     }
// }



// OPTIMIZED APPROACH although above are also good 
// size of wordA must be exactly one less than the wordB 
// need to first sort on size 
// use unordered map and check by removing on char each time if match


class Solution {

    public int longestStrChain(String[] words) {

        // Sort words by length
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        HashMap<String, Integer> dp = new HashMap<>();
        int maxLen = 1;

        for (String word : words) {

            dp.put(word, 1);

            for (int i = 0; i < word.length(); i++) {

                // Remove one character
                String prev = word.substring(0, i) + word.substring(i + 1);

                if (dp.containsKey(prev)) {
                    dp.put(word,
                            Math.max(dp.get(word), 1 + dp.get(prev)));
                }
            }

            maxLen = Math.max(maxLen, dp.get(word));
        }

        return maxLen;
    }
}
