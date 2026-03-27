class NumArray {

    int[] arr;  // make it instance variable

    public NumArray(int[] nums) {
        arr = new int[nums.length];
        
        arr[0] = nums[0];  // base case
        
        for(int i = 1; i < nums.length; i++) {
            arr[i] = arr[i - 1] + nums[i];  // prefix sum
        }
    }
    
    public int sumRange(int left, int right) {
        if(left == 0) return arr[right];   // edge case
        
        return arr[right] - arr[left - 1];
    }
}