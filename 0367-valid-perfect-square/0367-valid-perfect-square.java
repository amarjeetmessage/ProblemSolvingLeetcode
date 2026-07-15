class Solution {
    public boolean isPerfectSquare(int num) {
       int ans = (int)Math.sqrt(num);
       if(ans * ans == num){
        return true;
       } else{
        return false;
       }
    }
}