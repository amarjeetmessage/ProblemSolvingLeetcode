class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int left=0;
        int right=0;
        while(right < n){
            if(nums[right]==0){
                right++;
            }
            else{

            
                swap(nums,left,right);
                left++;
                right++;
            }
            
        }

    }
    void swap(int[]a,int i, int j ){
        if (i==j)   return;
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}