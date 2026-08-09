class Solution {

    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[] ans = new int[m];

        /*
         * last[j] = latest index in word1 from which
         * word2[j...m-1] can be matched exactly.
         */
        int[] last = new int[m];

        Arrays.fill(last, -1);

        int i = n - 1;
        int j = m - 1;

        while (i >= 0 && j >= 0) {

            if (word1.charAt(i) == word2.charAt(j)) {
                last[j] = i;
                j--;
            }

            i--;
        }

        /*
         * Greedily scan word1 from left to right.
         *
         * We use at most one mismatch.
         */
        boolean mismatchUsed = false;

        j = 0;

        for (i = 0; i < n && j < m; i++) {

            // Exact match
            if (word1.charAt(i) == word2.charAt(j)) {

                ans[j] = i;
                j++;

            }

            // Use our one allowed mismatch
            else if (!mismatchUsed) {

                /*
                 * If this is the last character of word2,
                 * we can always use the mismatch.
                 *
                 * Otherwise, we need to make sure the
                 * remaining word2[j+1...] can be matched
                 * after index i.
                 */
                if (j == m - 1 || i < last[j + 1]) {

                    ans[j] = i;
                    j++;

                    mismatchUsed = true;
                }
            }
        }

        /*
         * Couldn't match all characters.
         */
        if (j < m) {
            return new int[0];
        }

        return ans;
    }
} 
//POTD