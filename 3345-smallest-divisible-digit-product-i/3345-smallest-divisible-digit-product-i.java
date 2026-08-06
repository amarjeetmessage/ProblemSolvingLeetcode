class Solution {
    public int smallestNumber(int n, int t) {
        
        int num=n;
        int ans=0;
        for(int i =0; i<=10; i++){
            int x=num+i;
            int p=1;
            while(x>0){
                int d=x%10;
                p=p*d;
                x/=10;
            }
            if(p % t ==0)   {
                ans= num+i;
                break;
            }
        }

    return ans;
    }
}