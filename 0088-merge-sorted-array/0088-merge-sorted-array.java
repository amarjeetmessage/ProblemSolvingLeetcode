class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // //BRUTE FORCE APPROACH
        // for(int i = 0; i<n; i++){
        //     nums1[m+i] = nums2[i];
        // }
        // Arrays.sort(nums1);

        //OPTIMAL APPROACH USING THREE POINTER 
        int i = m - 1;      // pointer for nums1
        int j = n - 1;      // pointer for nums2
        int k = m + n - 1;  // pointer for merged array (nums1)

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // If nums2 still has remaining elements
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}
