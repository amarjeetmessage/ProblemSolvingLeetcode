// // class Solution {
// //     public int[] twoSum(int[] numbers, int target) {
// //         for(int i = 0; i< numbers.length; i++) {
// //             for(int j = i + 1; j< numbers.length; j++) {
// //                 if(numbers[i] + numbers[j] == target) {
// //                     return new int[] {i+1, j+1};
// //                 }
// //             }
// //         }return new int[] {};
// //     }
// // }



// //SOLVING USING TWO POINTER 
// //NOTE: LIKE TWO SUM WE CAN'T USE HASHMAP BECAUSE HERE SPACE COMPLEXITIES MUST BE O(1)

// class Solution {
//     public int[] twoSum(int[] numbers, int target) {

//         int i = 0;
//         int j = numbers.length-1;

//         while(i < j) {
//             int sum = numbers[i] + numbers[j];

//             if(sum > target) {
//                 j = j-1;
//             }else if(sum < target){
//                 i = i+1;
//             }else{
//                 return new int[] {i+1, j+1};
//             }
//         }return new int[] {};
//     }
// }




class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int[] ans = new int[2];
        
        int i = 0;
        int j = n-1;

        while(i<j){
            if(numbers[i] + numbers[j] == target){
                ans[0] = i+1;
                ans[1] = j+1;
                break;
            }if(numbers[i] + numbers[j] > target){
                j--;
                continue;
            }else{
                i++;
                continue;
            }
        }
        return ans;
    }
}