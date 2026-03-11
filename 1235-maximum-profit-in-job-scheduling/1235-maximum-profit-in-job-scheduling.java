class Solution {
    Integer dp[];
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
       
        int n=startTime.length;
         dp=new Integer[n+1];
        int[][] join=new int[n][3];
        for(int i=0;i<join.length;i++){
            join[i][0]=startTime[i];
            join[i][1]=endTime[i];
            join[i][2]=profit[i];
        }
        Arrays.sort(join,(a,b)->a[0]-b[0]);
        return solve(0,join);
    }
    public int solve(int i,int[][]join){
        if(i>=join.length)return 0;


        if(dp[i]!=null){
            return dp[i];
        }
        int next=findNext(i,join);
        //pick
        int pick=join[i][2]+solve(next,join);
        //skip
        int skip=solve(i+1,join);
        return dp[i]=Math.max(pick,skip);
    }
    public int findNext(int i,int[][]join){
        for(int j=i+1;j<join.length;j++){
            if(join[j][0]>=join[i][1])return j;
        }
        return join.length;
    }
}//notdone