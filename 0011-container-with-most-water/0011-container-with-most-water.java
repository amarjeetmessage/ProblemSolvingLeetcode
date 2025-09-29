class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            // find the minimum height between two bars
            int minHeight = Math.min(height[left], height[right]);
            
            // calculate area
            int area = minHeight * (right - left);
            
            // update max area
            max = Math.max(max, area);

            // move the pointer with smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
