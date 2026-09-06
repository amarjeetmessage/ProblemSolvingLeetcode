// class Solution {
//     public int solve(int m, int n, String s, String t,int[][] dp) {
//         // base case
//         if(n == t.length()) {
//             return 1;
//         }
//         if(m == s.length()){
//             return 0;
//         }

//         if(dp[m][n] != -1) {
//             return dp[m][n];
//         }
//         // match
//         if(s.charAt(m) == t.charAt(n)) {
//             int take = solve(m+1,n+1,s,t,dp);
//             int notake = solve(m+1,n,s,t,dp);
//             return dp[m][n] = take + notake;
//         }
//         // not match
//         return dp[m][n] = solve(m+1,n,s,t,dp);
//     }
//     public int numDistinct(String s, String t) {
//         int m = s.length();
//         int n = t.length();
//         int[][] dp = new int[m+1][n+1]; // make it long type as per question given
//         for(int i = 0; i<=m; i++){
//             Arrays.fill(dp[i] , -1);
//         }
//         return solve(0,0,s,t,dp);
//     }
// }




// class Solution {
//     public int solve(int m, int n, String s, String t) {
//         // base case
//         if(n == t.length()) {
//             return 1;
//         }
//         if(m == s.length()){
//             return 0;
//         }

//         // match 
//         // agar match kar bhi jaye to no match wala chalana hoga kyuki dry run for this "amarjeetamarjeet" and "amarjeet" will count only one time and return 
//         if(s.charAt(m) == t.charAt(n)) {
//             int take = solve(m+1,n+1,s,t);
//             int notake = solve(m+1,n,s,t);
//             return take + notake;
//         }
//         // not match
//         return solve(m+1,n,s,t);
//     }
//     public int numDistinct(String s, String t) {
    
//         return solve(0,0,s,t);
//     }
// }





class Solution {
    public int numDistinct(String s, String t) {

        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n + 1][m + 1];

        // j == m
        for (int i = 0; i <= n; i++) {
            dp[i][m] = 1;
        }

        // Fill table
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {

                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }

        return dp[0][0];
    }
}