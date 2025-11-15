// class Solution {
//     public int minDistance(String word1, String word2) {
//         int m = word1.length();
//         int n = word2.length();

//         int[][] dp = new int[m+1][n+1];
//         for(int[] row : dp) {
//             Arrays.fill(row, -1);
//         }
//         return solve(word1, word2, m-1, n-1,dp);
//     }
//     public static int solve(String word1, String word2, int m, int n,int[][] dp) {
//         if(m < 0 && n < 0) return 0;
//         if(m < 0 || n < 0) return Math.abs(m - n);

//         if(dp[m][n] != -1) {
//             return dp[m][n];
//         }

//         if(word1.charAt(m) == word2.charAt(n)) {
//             dp[m][n] = solve(word1, word2,m-1,n-1,dp);
//             return dp[m][n];
//         }else{
//             int ins = solve(word1,word2,m,n-1,dp);
//             int del = solve(word1,word2,m-1,n,dp);
//             int repl = solve(word1,word2,m-1,n-1,dp);

//             dp[m][n] = 1+ Math.min(ins, Math.min(repl,del));
//             return dp[m][n];
//         }
//     }
// }



class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

    
        for (int i = 0; i <= m; i++) dp[i][0] = i; 
        for (int j = 0; j <= n; j++) dp[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = dp[i][j - 1];
                    int delete = dp[i - 1][j];
                    int replace = dp[i - 1][j - 1];
                    dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[m][n];
    }
}

