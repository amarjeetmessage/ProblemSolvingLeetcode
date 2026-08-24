class Solution {
    public int reverse(int x) {
        long num = x;
        
        if(num < 0) num = -num;
        long reverseNum = 0;
        while(num > 0){
            long rem = num % 10;
            reverseNum = reverseNum * 10 + rem;
            if(reverseNum > Integer.MAX_VALUE) return 0;
            num /= 10; 
        }
        return x < 0 ? (int)-reverseNum : (int)reverseNum;
    }
}