class Solution {
    public boolean isPalindrome(int x) {
        int rev = 0;
        int temp = x;
        if(x <= 0){
            return false;
        }
        while (x != 0) {
            int digit = x % 10;      // extract last digit
            rev = rev * 10 + digit;  // build reversed number
            x = x / 10;              // remove last digit
        }
        
        if(rev == temp){
            return true;
        }else return false;
    }
}