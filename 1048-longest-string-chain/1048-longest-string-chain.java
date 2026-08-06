// size of wordA must be exactly one less than the wordB 
// need to first sort on size 

public class Solution {
    public boolean isPredecessor(String word1, String word2) {
        if (word1.length() + 1 != word2.length()) {
            return false;
        }

        int i = word1.length() - 1;
        int j = word2.length() - 1;

        while (i >= 0 && j >= 0) {
            if (word1.charAt(i) == word2.charAt(j)) {
                i--;
                j--;
            } else {
                j--;
            }
        }

        return i < 0;
    }

    public int longestStrChain(String[] words) {
        // sorting on the basis of word length
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n = words.length;
        int[] LCS = new int[n];
        Arrays.fill(LCS, 1);
        int maxLength = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (isPredecessor(words[j], words[i])) {
                    LCS[i] = Math.max(LCS[i], 1 + LCS[j]);
                }
            }

            maxLength = Math.max(maxLength, LCS[i]);
        }

        return maxLength;
    }
}