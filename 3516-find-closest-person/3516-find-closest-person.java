class Solution {
    public int findClosest(int x, int y, int z) {
        int diff1 = Math.abs(z - x); // absolute difference
        int diff2 = Math.abs(z - y);

        if (diff1 < diff2) {
            return 1;  // x is closer
        } else if (diff2 < diff1) {
            return 2;  // y is closer
        } else {
            return 0;  // both are equally close
        }
    }
}
