class Solution {
    public int pivotIndex(int[] nums) {
        int n =nums.length;
        // if(n == 1) return 0;
        int sum = 0;
        for(int i =0; i<n; i++){
            sum = sum + nums[i];
        }

        int hsum = 0;
        for(int i = 0; i<n; i++){
            
            if(hsum *2 + nums[i] == sum){
                return i;
            }

            else {
                hsum = hsum + nums[i];
            }
        }
        return -1;
    }
}