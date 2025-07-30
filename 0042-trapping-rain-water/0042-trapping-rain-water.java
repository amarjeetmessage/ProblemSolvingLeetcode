class Solution {
    public int trap(int[] height) {
        //calculating left max boundary
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];
        for(int i = 1; i<height.length; i++){
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }

        //calculating right max boundary
        int rightMax[] = new int[height.length];
        rightMax[height.length-1] = height[height.length-1];
        for(int i = height.length-2; i>= 0; i--){
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }


        //loop to calculate trapped water 
        int trappedWater = 0;
        for(int i = 0; i < height.length; i++){
            //water level = min of (leftmax boundary , rightmax boundary)
            int waterLevel = Math.min(leftMax[i] , rightMax[i]);

            //trapped water = waterlevel - height[i]
            trappedWater += waterLevel - height[i];
        }
        return trappedWater;
    }
}