class Solution {
    public int reverse(int x) {
        long rev = 0;  // use long to handle overflow temporarily
        
        while (x != 0) {
            int digit = x % 10;      // extract last digit
            rev = rev * 10 + digit;  // build reversed number
            x = x / 10;              // remove last digit
        }
        
        // check overflow for 32-bit signed integer
        if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
            return 0;
        }
        
        return (int) rev;
    }
}
