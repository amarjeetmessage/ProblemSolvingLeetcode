// class Solution {
//     public int findDuplicate(int[] nums) {
//         Set<Integer> set = new HashSet<>();

//         for(int num : nums) {
//             if(set.contains(num) ) {
//                 return num;
//             }
//             set.add(num);
//         }
//         return -1;
//     }
// }



// we can also solve by cyclic sort but not good 

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        // Phase 1: Find intersection point
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find the entrance of the cycle (duplicate)
        slow = 0; // or n1 = 0
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow; // duplicate number
    }
}
