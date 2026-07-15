class Solution {
    public boolean isPowerOfThree(int n) {
        if(n == 1){
            return true;
        }
        if(n <=2){
            return false;
        }
        if(n % 3 != 0) {
            return false;
        }
        if(n == 3){
            return true;
        }

        return isPowerOfThree(n / 3);
    }
}