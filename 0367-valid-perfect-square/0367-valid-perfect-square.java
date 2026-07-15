class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1) return true;

        int s = 0;
        int e = num/2;

        while(s<=e) {
            int mid = s+(e-s)/2;
            long square = (long)mid * mid;
            if(square == num) return true;

            if(square > num) {
                e = mid -1;
            }else{
                s = mid +1;
            }
        }
        return false;
    }
}