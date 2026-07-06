class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;

        int left = 0;
        int right = n - 1;

        int leftMax = 0;
        int rightMax = 0;

        while(left < right) {
            if(height[left] <= height[right]){
                leftMax = Math.max(leftMax, height[left]);
                ans = ans + leftMax - height[left];
                left++;
            }else{
                rightMax = Math.max(rightMax, height[right]);
                ans = ans + rightMax - height[right];
                right--;
            }
        }

        return ans; 
    }
}