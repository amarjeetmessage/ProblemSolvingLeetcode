class Solution {
    public long countCommas(long n) {
        long ans = 0;
        for(long i = 1000,c = 1; i<=n; i*= 1000,c++){
            ans += Math.max(0,Math.min(n,i*1000-1) - i + 1) * c;
            
        }return ans;
        
    }
}