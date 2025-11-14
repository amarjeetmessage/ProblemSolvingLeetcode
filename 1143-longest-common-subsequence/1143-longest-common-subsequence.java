class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        return solve(text1,text2,m-1,n-1);
    }
    public static int solve(String text1, String text2, int m, int n) {
        if(m < 0 || n < 0) return 0;

        if(text1.charAt(m) != text2.charAt(n)) {
            int a = solve(text1, text2,m-1,n);
            int b = solve(text1, text2,m,n-1);

            return Math.max(a,b);
        }else {
            return 1 + solve(text1 , text2, m-1, n-1);
        }
    }
}