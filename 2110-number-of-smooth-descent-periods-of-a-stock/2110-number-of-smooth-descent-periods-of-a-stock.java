class Solution {
    public long getDescentPeriods(int[] prices) {
        int i=0,j=0;
        long n=0;
        while(i<prices.length){
            j=i+1;
            while(j<prices.length && prices[j]+1==prices[j-1]){
                j++;
            }
            long k=j-i;
            n=n+(k*(k+1))/2;
            i=j;


        }
        return n;
        
    }
}