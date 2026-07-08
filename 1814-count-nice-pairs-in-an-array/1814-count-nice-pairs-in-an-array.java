// class Solution {

//     public int reverse(int n){

//         int ans = 0;

//         while(n > 0){
//             int digit = n % 10;
//             ans = ans * 10 + digit;
//             n /= 10;
//         }

//         return ans;
//     }

//     public int countNicePairs(int[] nums) {

//         int n = nums.length;
//         int count = 0;

//         for(int i = 0; i < n; i++){

//             for(int j = i + 1; j < n; j++){

//                 if(nums[i] + reverse(nums[j]) ==
//                    nums[j] + reverse(nums[i])){

//                     count++;
//                 }
//             }
//         }

//         return count;
//     }
// }




class Solution {

    static final int MOD = 1_000_000_007;

    public int reverse(int x){

        int rev = 0;

        while(x > 0){
            rev = rev * 10 + x % 10;
            x /= 10;
        }

        return rev;
    }

    public int countNicePairs(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();

        long ans = 0;

        for(int num : nums){

            int diff = num - reverse(num);

            ans = (ans + map.getOrDefault(diff,0)) % MOD;

            map.put(diff, map.getOrDefault(diff,0)+1);
        }

        return (int)ans;
    }
}