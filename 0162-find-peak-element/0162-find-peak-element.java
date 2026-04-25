class Solution {

    // ==============================
    // 1. Brute Force (O(n))
    // ==============================
    /*
    Idea:
    - Traverse linearly
    - The moment we see a drop (nums[i] > nums[i+1]), i is a peak
    - If no drop, last element is peak

    Why it works:
    - Peak = element greater than neighbors
    - A drop guarantees previous element is greater than next
    */
    public int bruteForce(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }

        return n - 1;
    }


    // ==============================
    // 2. Type-1 Binary Search (i <= j)
    // ==============================
    /*
    Idea:
    - Classic binary search style
    - Check if mid is peak using neighbors
    - If left neighbor is bigger → go left
    - Else → go right

    Why:
    - We are explicitly verifying peak condition at mid

    Pattern:
    - Uses i <= j
    - Uses ans variable
    */
    public int type1BS(int[] nums) {
        int n = nums.length;
        int i = 0, j = n - 1;
        int ans = -1;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            boolean leftOk = (mid == 0) || nums[mid] > nums[mid - 1];
            boolean rightOk = (mid == n - 1) || nums[mid] > nums[mid + 1];

            // If both sides smaller → peak
            if (leftOk && rightOk) {
                ans = mid;
                break;
            }
            // If left is bigger → peak lies on left side
            else if (mid > 0 && nums[mid - 1] > nums[mid]) {
                j = mid - 1;
            }
            // Else → go right
            else {
                i = mid + 1;
            }
        }

        return ans;
    }


    // ==============================
    // 3. Type-2 Binary Search (BEST)
    // ==============================
    /*
    Idea:
    - Use slope logic instead of checking both sides

    Key Observation:
    - If nums[mid] > nums[mid+1] → we are in decreasing slope → peak is on left (including mid)
    - Else → increasing slope → peak is on right

    Why it works:
    - Peak always exists
    - We shrink search space toward the peak

    Pattern:
    - Uses i < j
    - No ans variable
    - Boundary-based binary search
    */
    public int findPeakElement(int[] nums) {
        int i = 0, j = nums.length - 1;

        while (i < j) {
            int mid = i + (j - i) / 2;

            if (nums[mid] > nums[mid + 1]) {
                j = mid;       // move left (keep mid)
            } else {
                i = mid + 1;   // move right
            }
        }

        return i;
    }
}