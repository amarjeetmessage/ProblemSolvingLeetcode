class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int n = nums.length;

        int max = 0;
        for(int i = 0; i<n; i++) {
            max = Math.max(max, nums[i]);
        }

        int arr[] = new int[max + 1];

        for(int x : nums){
            arr[x] = arr[x] + x;
        }

        int[] dp = new int[max+1];

        dp[0] = arr[0];
        // if(n>=2) {
            dp[1] = Math.max(arr[0], arr[1]);
        // }

        for(int i = 2; i<=max; i++) {
            dp[i] = Math.max(dp[i-1], arr[i] + dp[i-2]);
        }

        return dp[max];
        
    }
}















// class Solution {
//     public int deleteAndEarn(int[] nums) {
//         int n = nums.length;

//         int max = 0;
//         for(int i = 0; i<n; i++) {
//             max = Math.max(max, nums[i]);
//         }

//         int arr[] = new int[max + 1];

//         for(int x : nums){
//             arr[x] = arr[x] + x;
//         }

//         int[] dp = new int[max+1];
//         Arrays.fill(dp, -1);

//         return solve(arr,max,dp);
        
//     }
//     public int solve(int[] arr, int n,int[] dp) {
        
//         if(n <= 0) return arr[0];
//         if(n>=2) {
//             if(n == 1) return Math.max(arr[0],arr[1]);
//         }

//         if(dp[n] != -1) {
//             return dp[n];
//         }
        
//         int a = solve(arr, n-1,dp);
//         int b = arr[n] + solve(arr, n-2,dp);

//         return dp[n] = Math.max(a,b);

//     }
// }