class Solution {
    public int removeElement(int[] nums, int val) {
        // [0,1,2,2,3,0,4,2] k == 2;
        // [0,1,4,0,3,2,2,2]

        int n = nums.length;
        int i = 0;
        int j = n-1;
        int k = 0;

        while(i<=j){
            if(nums[i] == val){
                if(nums[j] == val){
                    j--;
                }else{
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i++;
                    j--;
                    k++;
                }
            }else{
                i++;
                k++;
            }
        }

        return k;
    }
}