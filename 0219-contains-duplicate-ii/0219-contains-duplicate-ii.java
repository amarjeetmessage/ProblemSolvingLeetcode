// class Solution {
//     public boolean containsNearbyDuplicate(int[] nums, int k) {
//       for(int i = 0; i<nums.length-1; i++) {
//         for(int j = i+1; j<nums.length; j++) {
//             if(nums[i] == nums[j]) {
//                 if(Math.abs(i-j) <= k){
//                     return true;
//                 }
//             }else {
//                 continue;
//             }
//         }
//       } 
//       return false; 
//     }
// }





// class Solution {
//     public boolean containsNearbyDuplicate(int[] nums, int k) {
//       for(int i = 0; i<nums.length; i++) {
//         Set<Integer> set = new HashSet<>();
//         for(int j = i; j<= Math.min(i+k,nums.length-1) ; j++) {
//             if(set.contains(nums[j])) {
//                 return true;
//             }else{ 
//                 set.add(nums[j]);
//             }
//         }
//       }
//         return false;
//     }
// }




class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < Math.min(k , nums.length); i++) {
            if(set.contains(nums[i])) {
                return true;
            }else{
                set.add(nums[i]);
            }
        }

        for(int i = k ; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                return true;
            }else{
                set.add(nums[i]);
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}


// Math.min(k , nums.length) THIS IS NEEDED BECAUSE IF K > NUMS.LENGTH CASE