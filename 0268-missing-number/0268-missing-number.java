// class Solution {
//     public int missingNumber(int[] nums) {
//         int res = nums.length;
        
//         for (int i = 0; i < nums.length; i++) {
//             res += i - nums[i];
//         }
        
//         return res;       
//     }
// }



// class Solution {
//     public int missingNumber(int[] nums) {
//         HashSet<Integer> set = new HashSet<>();
//         for(int num : nums) {
//             set.add(num);
//         }
//         for(int i = 0; i<nums.length;i++){
//             if(!set.contains(i)){
//                 return i;
//             }
//         }
//         return nums.length;
//     }
// }



// without sorting and linear search or binary search 
// or without using HashSet which solve in O(n) but space complexity will be O(n)

// use of cyclic sorting to solve in O(n) with constant space

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int i = 0;
        //in - place nums array ko modify karke 
        //sahi index par pahuchate hai

        //cyclic sorting
        while(i < n) {
            int correctIndex = nums[i];// due to starts with 0
            
            //exception
            if(correctIndex >= nums.length) {
                i = i+1;
            }
            else if(nums[correctIndex] != nums[i]) {
                int temp = nums[correctIndex];
                nums[correctIndex] = nums[i];
                nums[i] = temp;
            }

            else {
                i = i+1;
            }
        }

        for(int k = 0; k< n; k++){
            if(nums[k] != k){
                return k;
            }
        }
        return n;

    }
}

