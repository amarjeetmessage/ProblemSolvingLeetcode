class Solution {
    public int longestSubsequence(int[] nums) {
        int n=nums.length;
        int xor=0;
        boolean hasnonzero=false;
        for(int x:nums){
            xor^=x;
            if(x!=0){
                hasnonzero=true;
            }
        }
        if(xor!=0){
            return n;
        }
        if(hasnonzero){
            return n-1;
        }
        return 0;
    }
}//potd