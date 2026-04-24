class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int n = moves.length();
        int left = 0;
        int right = 0;
        int under = 0;

        for(int i = 0; i<n; i++) {
            if(moves.charAt(i) == 'L'){
                left++;
            }
            else if(moves.charAt(i) == 'R'){
                right++;
            }else{
                under++;
            }
        }
        if(left == right){
            return under;
        }
        else if(left > right){
            return under+Math.abs(right-left);
        }else{
            return under+Math.abs(left-right);
        }
    }
}