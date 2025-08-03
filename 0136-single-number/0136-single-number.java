class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int num:nums){
            result ^= num;
        }
        return result;
    }
}




// class Solution {
//     public int singleNumber(int[] nums) {

//         // Initialize result as 0.
//         // This will hold the unique number after XORing all elements.
//         int result = 0;

//         // Enhanced for-loop: for each number in the array 'nums'
//         for (int num : nums) {

//             // XOR the current number with result.
//             // Why XOR? 
//             // Because XOR has special properties:
//             //   1) a ^ a = 0    (same number twice cancels out)
//             //   2) a ^ 0 = a    (XOR with zero keeps the number)
//             //
//             // So, pairs will cancel each other,
//             // leaving only the number that does not have a pair.

//             result ^= num; // same as: result = result ^ num;

//             /*
//              Example: nums = [4, 1, 2, 1, 2]
//              Steps:
//                result = 0
//                result ^= 4 -> result = 4
//                result ^= 1 -> result = 4 ^ 1 = 5
//                result ^= 2 -> result = 5 ^ 2 = 7
//                result ^= 1 -> result = 7 ^ 1 = 6 (1 cancels out)
//                result ^= 2 -> result = 6 ^ 2 = 4 (2 cancels out)

//                Final result = 4 (the unique number)
//             */
//         }

//         // After the loop, result holds the single number.
//         return result;
//     }
// }
