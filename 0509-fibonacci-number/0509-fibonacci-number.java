// class Solution {
//     public int fib(int n) {
//         //recursion
//         if(n == 0 || n == 1) return n;
//         return fib(n-1) + fib(n-2);
//     }
// }



// class Solution {
//     public int fib(int n) {
//         int[] dp = new int[n+1];
//         Arrays.fill(dp, -1);

//         if(n == 0 || n == 1) return n;

//         if(dp[n] != -1){
//             return dp[n];
//         }

//         dp[n] = fib(n-1) + fib(n-2);

//         return dp[n];
//     }
// }


// class Solution {
//     public int fib(int n) {
//         int[] dp = new int[n+1];
//         if(n == 0 ) return 0;// need to handle due to if only 0 then can't dp[1] = 1;
//         dp[0] = 0;
//         dp[1] = 1;

//         for(int i = 2; i<=n; i++){
//             dp[i] = dp[i-1] + dp[i-2];
//         }

//         return dp[n];
//     }

// }



class Solution {
    public int fib(int n) {
        int[] dp = new int[3];
        if(n == 0) return n;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for(int i = 3; i<=n; i++){
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = dp[0] + dp[1];
        }
        return dp[2];
    }
}