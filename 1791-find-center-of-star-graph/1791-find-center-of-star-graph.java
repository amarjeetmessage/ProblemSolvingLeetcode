class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int len = edges.length;
        
        for(int i = 0; i<len; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];

            freqMap.put(v1,freqMap.getOrDefault(v1, 0) + 1);// key == v1, value == freqMap.getOrDefault(v1, 0)
            freqMap.put(v2,freqMap.getOrDefault(v2, 0) + 1);

            if(freqMap.get(v1) == len) {
                return v1;
            }
            if(freqMap.get(v2) == len) {
                return v2;
            }
        }
        return -1 ;
    }
}