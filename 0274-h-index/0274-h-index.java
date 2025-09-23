import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);   // Step 1: sort ascending
        int n = citations.length;

        for(int i = 0; i < n; i++){
            int h = n - i;  // remaining papers count
            if(citations[i] >= h){
                return h;
            }
        }
        return 0;
    }
}
