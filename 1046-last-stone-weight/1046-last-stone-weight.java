class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        //arraylist to modify 
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i<n; i++){
            arr.add(stones[i]);
        }

        while (arr.size() > 1) {
            Collections.sort(arr);
            int a = arr.remove(arr.size() - 1);
            int b = arr.remove(arr.size() - 1);

            if(a > b){
                arr.add(a - b);
            }
        }
        if(arr.size() == 1){
            return arr.get(0);
        }else return 0;
    }
}