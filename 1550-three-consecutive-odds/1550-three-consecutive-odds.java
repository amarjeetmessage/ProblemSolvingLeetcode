class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
    for (int pos : arr) {
        if (pos % 2 != 0) {
            count++;
            if (count == 3) {
                return true;
            }
        } else {
            count = 0;
        }
    }
    return false;
    }
}