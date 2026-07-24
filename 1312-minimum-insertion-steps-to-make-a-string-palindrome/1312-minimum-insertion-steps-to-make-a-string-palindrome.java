

// solving by own new method 

// solving by lcs(leetcode 1143) method 
class Solution {
    public int solve(int i, int j, String s,int[][] dp) {
        // base case
        if(i == j) return 1;
        if(i>j) return 0;

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = 2 + solve(i+1,j-1,s,dp);
        }else{
            return dp[i][j] = Math.max(solve(i+1,j,s,dp),solve(i,j-1,s,dp));
        }
    }
    public int minInsertions(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for(int i = 0; i<len; i++){
            Arrays.fill(dp[i], -1);
        }
        return len - solve(0,len-1,s,dp);
    }
}