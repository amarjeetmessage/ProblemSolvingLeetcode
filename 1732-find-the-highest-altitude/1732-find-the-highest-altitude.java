class Solution {
    public int largestAltitude(int[] gain) {
        int altit = 0;
        int max = 0;
        for(int val: gain){
            altit += val;
            max = Math.max(max, altit);
        }
        return max;
    }
}