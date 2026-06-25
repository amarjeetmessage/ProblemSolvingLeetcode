class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n= nums.length;
        int []prefix=new int[n+1];
        for(int i=0; i<n; i++){
            
            if( nums[i]==target){
                nums[i]=1;
            }
            else{
                nums[i]=-1;
            }
            prefix[i+1]=prefix[i]+nums[i];
        }
        int count=0;
        for(int l = 0; l < n; l++){
            for(int r = l; r < n; r++){

                int sum = prefix[r + 1] - prefix[l];

                if(sum>0){
                    count++;
                }
            }
        }
        return count;
    }
}