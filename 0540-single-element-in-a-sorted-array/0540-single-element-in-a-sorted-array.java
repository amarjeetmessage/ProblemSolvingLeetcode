// class Solution {
//     public int singleNonDuplicate(int[] nums) {
//         int n = nums.length;
//         for (int i = 0; i < n - 1; i += 2) {
//             if (nums[i] != nums[i + 1]) {
//                 return nums[i];
//             }
//         }
//         return nums[n - 1]; // handle last element
//     }
// }




class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[n - 1] != nums[n - 2]) return nums[n - 1];

        int low = 1;
        int high = n - 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Found the single element
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            // We are on the left (correct pairing)
            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) ||
                (mid % 2 == 1 && nums[mid] == nums[mid - 1])) {
                low = mid + 1;
            }
            // We are on the right side
            else {
                high = mid - 1;
            }
        }

        return -1;
    }
}