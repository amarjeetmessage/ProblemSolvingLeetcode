class Solution {
    public int sum(int n){
        int tot=0;
        while(n>0){
            tot+=n%10;
            n=n/10;

        }
        return tot;
    }
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(i==sum(nums[i]))return i;
        }
        return -1;
        
    }
}