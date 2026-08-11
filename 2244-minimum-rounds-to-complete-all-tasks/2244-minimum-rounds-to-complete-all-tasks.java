class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : tasks) {
            map.put(x, map.getOrDefault(x, 0)+1);
        }


        int res = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() <= 1){
                return -1;
            }
            else{
                res = res + entry.getValue() / 3;
                if(entry.getValue() % 3 == 1 || entry.getValue() % 3 == 2){
                    res++;
                }
            }
        }
        return res;
    }
}