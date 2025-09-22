class Solution {
    public int earliestTime(int[][] tasks) {
        int min = Integer.MAX_VALUE;
        for(int[] element : tasks){
            int a = element[0];
            int b = element[1];
            int sum = a+b;
            min = Math.min(min,sum);
        }
        return min;
    }
}