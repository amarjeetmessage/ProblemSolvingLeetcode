class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int i = findFirstOccurrence(nums, target);
        if(i == -1){
            return new int[] {-1,-1};
        }
        int j = findLastOccurence(nums, target);

        return new int[] {i,j};

    }
    public static int findFirstOccurrence(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        int ans = -1;
        while(left <= right) {
            int mid = (left + right) / 2;

            if(nums[mid] == target) {
                ans = mid;
                right = mid-1;
            }else if(nums[mid] < target){
                left = mid+1;
            }else{
                right = mid -1;
            }
        }
        return ans;
    }
    public static int findLastOccurence(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;

        int ans = -1;
        while(left <= right) {
            int mid = (left + right) / 2;

            if(nums[mid] == target){
                ans = mid;
                left = mid+1;
            }else if(nums[mid] < target) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return ans;
    }
}