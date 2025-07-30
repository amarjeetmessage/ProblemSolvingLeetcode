class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = {-7, -4, -1, 0, 3, 5, 9, 12};
        int target = 0;
        System.out.println("Index of key is : " + new Solution().search(nums, target));  // Corrected method call
    }
}
