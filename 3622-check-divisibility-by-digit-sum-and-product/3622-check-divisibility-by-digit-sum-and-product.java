class Solution {
    public boolean checkDivisibility(int n) {
        int digit = n; // need to store due to it will become 0 in while loop;
        int sum = 0;
        int prod = 1;
        while(n > 0){
            int a = n % 10;
            sum += a;
            prod *= a;
            n /= 10;
        }
        if(digit % (sum + prod) == 0){
            return true;
        }else return false;
    }
}