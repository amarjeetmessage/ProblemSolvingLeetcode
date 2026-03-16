class Solution {
    int[][] dp;
    public int lastStoneWeightII(int[] stones) {
        int stn = 0;
        for(int ele: stones) stn += ele;
        dp = new int[(stn/2)+1][stones.length];
        for(int[] ele: dp) Arrays.fill(ele, -1);
        
        int ans = finder(stones, 0, 0, stn/2);

        return stn-(2*ans);
    }
    public int finder(int[] stones, int i, int cur, int tar) {
        if(cur > tar) return Integer.MIN_VALUE;
        if(i >= stones.length) return cur;
        if(dp[cur][i] != -1) return dp[cur][i];

        int accept = finder(stones, i+1, cur+stones[i], tar);
        int skip = finder(stones, i+1, cur, tar);
        
        return dp[cur][i] = Math.max(accept, skip);
    }
}
//this is just two subset diff minimum value
