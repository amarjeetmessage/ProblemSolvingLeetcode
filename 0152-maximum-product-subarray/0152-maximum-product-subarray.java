class Solution {
    public int maxProduct(int[] nums) {
        // int n = nums.length;
    
        // int max = Integer.MIN_VALUE;
        // for(int i = 0; i<n; i++){
        //     int product = 1;
        //     for(int j = i; j<n; j++){
        //         product = product * nums[j];
        //         max = Math.max(max, product); 
        //     }
        // }
        // return max;


        //using kadane's algorithm (DIFF CONCEPT THAN SUM QUES)
        // HERE WE NEED TO MAIN TWO (MIN AND MAX) DUE TO NEG * NEG CAN BECOME POSITIVE SO NEEDN'T LEAVE MIN VALUE
        int n = nums.length;
        int max = nums[0];

        int maxProduct = nums[0];
        int minProduct = nums[0];

        for(int i = 1; i<n; i++){

            if(nums[i] < 0){
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = Math.max(nums[i], maxProduct * nums[i]);
            minProduct = Math.min(nums[i], minProduct * nums[i]);

            max = Math.max(max, maxProduct);
        }
        return max;
    }
}