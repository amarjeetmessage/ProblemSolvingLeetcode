// class Solution {
//     public int majorityElement(int[] nums) {
//       for(int i = 0; i<nums.length; i++) {
//         int count = 0;
//         for(int j = 0; j<nums.length; j++) {
//             if(nums[i] == nums[j]) {
//                 count++;
//             }
//         }
//         if(count > nums.length / 2) {
//             return nums[i];
//         }
//       } 
//       return -1; 
//     }
// }

class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //find Element
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > n/2) {
                return entry.getKey();
            }
        }
        return -1;
    }
}