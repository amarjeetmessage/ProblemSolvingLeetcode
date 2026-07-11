// class Solution {
//     public int missingNumber(int[] nums) {
//         int res = nums.length;
        
//         for (int i = 0; i < nums.length; i++) {
//             res += i - nums[i];
//         }
        
//         return res;       
//     }
// }


// without sorting and linear search or binary search or without using HashSet use of cyclic sorting to solve in O(n);

class Solution {
    public int missingNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        for(int i = 0; i<nums.length;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return nums.length;
    }
}

