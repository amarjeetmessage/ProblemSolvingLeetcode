class Solution {
    public int solve(int n) {

        if(n <= 1) return n;

        int fib[] = new int[n+1];
        //base case
        fib[0] = 0;
        fib[1] = 1;


        for(int i = 2; i<= n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }

        return fib[n];
    }
    public int fib(int n) {
        
       return solve(n);
    }
}