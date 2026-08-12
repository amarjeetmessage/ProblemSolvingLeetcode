// class Solution {
//     public int maxSubarrayLength(int[] nums, int k) {
//         // creater a two loop 
//         // for each time i starts create a new hashMap and maintain them 
//         // if freq exceeds then break and store j-i+1 as max


//         int n = nums.length;
//         int max = 0;

//         for(int i = 0; i<n; i++){
//             Map<Integer, Integer> map = new HashMap<>();
            
//             for(int j = i; j<n; j++){
//                 map.put(nums[j], map.getOrDefault(nums[j], 0)+1);
                
//                 if(map.get(nums[j]) > k){
//                     break;
//                 }

//                 max = Math.max(max, j-i+1);
//             }
//         }

//         return max;
//     }
// }





class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
       int n = nums.length;
       int i = 0;
       int ans = 0;

       Map<Integer, Integer> map = new HashMap<>();
       for(int j = 0; j<n; j++){
        
           map.put(nums[j] , map.getOrDefault(nums[j], 0)+1);

           // if exceeds freq shrink
           while(map.get(nums[j]) > k){
                map.put(nums[i], map.get(nums[i]) -1);
                i++;
           }


           ans = Math.max(ans, j-i+1);
       }     
       return ans;  
    }
}