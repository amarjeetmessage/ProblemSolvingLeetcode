// class Solution {
//     public int singleNumber(int[] nums) {
//         for(int i = 0; i<nums.length; i++) {
//             int count = 0;
//             for(int j = 0; j<nums.length; j++) {
//                 if(nums[i] == nums[j]) {
//                     count++;
//                 }
//             }
//             if(count == 1) {
//                 return nums[i];
//             }
//         }
//         return -1;
//     }
// }
class Solution {
    public int singleNumber(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Count frequency of each number
        for(int num : nums) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // Step 2: Find number with frequency = 1
        for(int num : map.keySet()) {
            if(map.get(num) == 1) {
                return num;
            }
        }

        return -1;
    }
}