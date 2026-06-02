class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int sum = 0;
        int n = cost.length;

        if(n == 1){
            return cost[0];
        }
        if(n == 2){
            return cost[0] + cost[1];
        }

        for(int i = cost.length-1; i>1; i= i-3){
            sum = sum + cost[i] + cost[i-1];

        }

        if(n % 3 == 1){
            sum = sum + cost[0];
        }
        if(n %3 ==  2){
            sum = sum + cost[0] + cost[1];
        }

        return sum;
    }
}