// solve same as lcs by making one new String reverse of given string
class Solution {
    public int lcs(int m, int n, String text1, String text2,int[][] dp){
        if(m == 0 || n == 0) return 0;

        if(dp[m][n] != -1){
            return dp[m][n];
        }

        if(text1.charAt(m-1) == text2.charAt(n-1)){
            return dp[m][n] = 1 + lcs(m-1,n-1,text1,text2,dp);
        }else{
            return dp[m][n] = Math.max(lcs(m-1,n,text1,text2,dp),lcs(m,n-1,text1,text2,dp));
        }
    }
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();

        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }

        String rev = new String(arr);

        int dp[][] = new int[len+1][len + 1];

        for(i = 0; i<=len; i++){
            Arrays.fill(dp[i],-1);
        }

        return lcs(len,len,s,rev,dp);
    }
}