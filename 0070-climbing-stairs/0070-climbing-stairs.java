// class Solution {
//     public int solve(int n ) {
//          if(n == 2 || n == 1) return n;
//         return climbStairs(n-1) + climbStairs(n-2);
//     }
//     public int climbStairs(int n) {
    
//        return solve(n);
//     }
// }





class Solution {
    public int solve(int n, int dp[] ) {
         if(n == 2 || n == 1) return n;

         if(dp[n] != -1){
            return dp[n];
         }

        dp[n] =  solve(n-1,dp) + solve(n-2,dp);
        return dp[n];
    }
    public int climbStairs(int n) {

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

    
       return solve(n,dp);
    }
}