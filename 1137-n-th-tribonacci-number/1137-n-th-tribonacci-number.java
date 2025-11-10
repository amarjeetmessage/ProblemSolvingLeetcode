class Solution {

    public static int findFibb(int n, int[] dp) {
        //base case 
        if(n == 0) return n;
        if(n == 1 || n == 2) return 1;
        
        //check first if it exists
        if(dp[n] != -1) {
            return dp[n];
        }

        dp[n] = findFibb(n-1, dp) + findFibb(n-2, dp) + findFibb(n-3, dp);
        return dp[n];
    }
    public int tribonacci(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return findFibb(n, dp);
    }
}