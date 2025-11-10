// class Solution {
//     public int fib(int n) {
//         if(n == 0 || n==1){
//             return n;
//         }
//         return fib(n-1) + fib(n-2);
//     }
// }

class Solution {

    public static int findFibb(int n, int[] dp) {
        //base case 
        if(n == 0 || n == 1) return n;
        
        //check first if it exists
        if(dp[n] != -1) {
            return dp[n];
        }

        dp[n] = findFibb(n-1, dp) + findFibb(n-2, dp);
        return dp[n];
    }
    public int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return findFibb(n, dp);
    }
}