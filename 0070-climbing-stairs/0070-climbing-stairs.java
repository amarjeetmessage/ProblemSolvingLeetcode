// class Solution {
//     public int solve(int n ) {
//          if(n == 2 || n == 1) return n;
//         return climbStairs(n-1) + climbStairs(n-2);
//     }
//     public int climbStairs(int n) {
    
//        return solve(n);
//     }
// }





// class Solution {
//     public int solve(int n, int dp[] ) {
//          if(n == 2 || n == 1) return n;

//          if(dp[n] != -1){
//             return dp[n];
//          }

//         dp[n] =  solve(n-1,dp) + solve(n-2,dp);
//         return dp[n];
//     }
//     public int climbStairs(int n) {

//         int[] dp = new int[n+1];
//         Arrays.fill(dp, -1);

    
//        return solve(n,dp);
//     }
// }





// class Solution {
//     public int solve(int n ,int[] dp) {

//         if(n == 1) return 1;

//         dp[1] = 1;
//         dp[2] = 2;

//         for(int i = 3; i<=n; i++){
//             dp[i] = dp[i-1] + dp[i-2];
//         }

//         return dp[n];
//     }
//     public int climbStairs(int n) {

//         int[] dp = new int[n+1];
//         // Arrays.fill(dp, -1);
    
//        return solve(n,dp);
//     }
// }




class Solution {
    public int solve(int n ,int[] dp) {
        if(n <= 2) return n;
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 3;

        for(int i = 4; i<=n; i++){
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = dp[0] + dp[1];
        }
        return dp[2];
    }
    public int climbStairs(int n) {
        
        int[] dp = new int[3];

       return solve(n,dp);
    }
}