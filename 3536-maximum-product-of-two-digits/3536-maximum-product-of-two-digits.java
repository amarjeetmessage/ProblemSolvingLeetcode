class Solution {
    public int maxProduct(int n) {
       List<Integer> list = new ArrayList<>();
       while(n > 0) {
            list.add(n % 10);
            n = n / 10;
       } 
       Collections.sort(list);
       int len = list.size();
       return list.get(len -1) * list.get(len - 2);
    }
}