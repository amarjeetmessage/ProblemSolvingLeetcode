// // recursive code  
// class Solution {
//     public int solve(int m, int n, String text1, String text2) {
//         // base case 
//         if(m == 0 || n == 0) return 0;

//         // recursive code 

//         // two case if char match
//         if(text1.charAt(m-1) == text2.charAt(n-1)) {
//             return 1 + solve(m-1,n-1,text1,text2);
//         }
//         // if not match
//         else{
//             return Math.max(solve(m-1,n,text1,text2) , solve(m,n-1,text1,text2));
//         }
//     }
//     public int longestCommonSubsequence(String text1, String text2) {
//         int m = text1.length();
//         int n = text2.length();
//         return solve(m,n,text1,text2);
//     }
// }



// // memoizaton code
// class Solution {
//     public int solve(int m, int n, String text1, String text2,int[][] dp) {
//         // base case 
//         if(m == 0 || n == 0) return 0;

//         if(dp[m][n] != -1) {
//             return dp[m][n];
//         }

//         // recursive code 

//         // two case if char match
//         if(text1.charAt(m-1) == text2.charAt(n-1)) {
//             return dp[m][n] =  1 + solve(m-1,n-1,text1,text2,dp);
//         }
//         // if not match
//         else{
//             return dp[m][n] = Math.max(solve(m-1,n,text1,text2,dp) , solve(m,n-1,text1,text2, dp));
//         }
//     }
//     public int longestCommonSubsequence(String text1, String text2) {
//         int m = text1.length();
//         int n = text2.length();
//         int[][] dp = new int[m+1][n+1];
//         for(int i = 0; i<=m; i++){
//             Arrays.fill(dp[i] , -1);
//         }
//         return solve(m,n,text1,text2,dp);
//     }
// }



// tabulation 
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i<=m; i++){
            Arrays.fill(dp[i] , 0);
        }

        // base case already 0 

        // start with 1 
        for(int i = 1; i<=m; i++){
            for(int j = 1; j<=n; j++){
                // if match
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}