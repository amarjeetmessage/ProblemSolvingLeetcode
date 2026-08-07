// class Solution {

//     int findMinCost(int start, int end, int rodStart, int rodEnd, int[] cuts) {

//         if (start > end) {
//             return 0;
//         }

//         int result = Integer.MAX_VALUE;

//         for (int k = start; k <= end; k++) {

//             int answer = (rodEnd - rodStart)
//                     + findMinCost(start, k - 1, rodStart, cuts[k], cuts)
//                     + findMinCost(k + 1, end, cuts[k], rodEnd, cuts);

//             result = Math.min(result, answer);
//         }

//         return result;
//     }

//     public int minCost(int n, int[] cuts) {

//         Arrays.sort(cuts);

//         return findMinCost(0, cuts.length - 1, 0, n, cuts);
//     }
// }







// import java.util.*;

// class Solution {

//     int findMinCost(int start, int end, int[] cuts) {

//         if (start + 1 == end) {
//             return 0;
//         }

//         int result = Integer.MAX_VALUE;

//         // Try every possible cut
//         for (int k = start + 1; k < end; k++) {

//             int answer = (cuts[end] - cuts[start])
//                     + findMinCost(start, k, cuts)
//                     + findMinCost(k, end, cuts);

//             result = Math.min(result, answer);
//         }

//         return result;
//     }

//     public int minCost(int n, int[] cuts) {

//         int m = cuts.length;

//         // Add 0 and n
//         int[] newCuts = new int[m + 2];
//         newCuts[0] = 0;
//         newCuts[m + 1] = n;

//         for (int i = 0; i < m; i++) {
//             newCuts[i + 1] = cuts[i];
//         }

//         Arrays.sort(newCuts);

//         return findMinCost(0, m + 1, newCuts);
//     }
// }







import java.util.*;

class Solution {

    int findMinCost(int start, int end, int[] cuts, int[][] dp) {

        if (start + 1 == end) {
            return 0;
        }

        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        int result = Integer.MAX_VALUE;

        // Try every possible cut
        for (int k = start + 1; k < end; k++) {

            int answer = (cuts[end] - cuts[start])
                    + findMinCost(start, k, cuts, dp)
                    + findMinCost(k, end, cuts, dp);

            result = Math.min(result, answer);
        }

        dp[start][end] = result;
        return result;
    }

    public int minCost(int n, int[] cuts) {

        int m = cuts.length;

        // Add 0 and n
        int[] newCuts = new int[m + 2];
        newCuts[0] = 0;
        newCuts[m + 1] = n;

        for (int i = 0; i < m; i++) {
            newCuts[i + 1] = cuts[i];
        }

        Arrays.sort(newCuts);

        int[][] dp = new int[m + 2][m + 2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return findMinCost(0, m + 1, newCuts, dp);
    }
}