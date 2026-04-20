// class Solution {
//     public int countPairs(List<Integer> nums, int target) {
//         int count = 0;
        
//         for(int i = 0; i < nums.size(); i++) {
//             for(int j = i + 1; j < nums.size(); j++) {
//                 if(nums.get(i) + nums.get(j) < target) {
//                     count++;
//                }
//             }
//         }
//         return count;
//     }
// }




//solve optimize using two pointer 
class Solution {
    public int countPairs(List<Integer> nums, int target) {
        nums.sort(null);

        int i = 0;
        int j = nums.size() -1;

        int count = 0;

        while(i<j) {
            int sum = nums.get(i) + nums.get(j);
            if(sum < target) {
                count += j-i;
                i = i+1;

            }else{
                j = j-1;
            }
        }
        return count;
    }
}
