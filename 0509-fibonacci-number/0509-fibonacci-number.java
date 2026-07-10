class Solution {
    public int solve(int n) {
        //base case
        if(n == 0 || n == 1) {
            return n;
        }
        // recursive call

        int res = solve(n-1) + solve(n-2);

        // return result
        return res;
    }
    public int fib(int n) {
       return solve(n);
    }
}