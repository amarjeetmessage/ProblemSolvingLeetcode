// class Solution {
//     public List<Integer> findDisappearedNumbers(int[] nums) {
//        int n = nums.length;
//        Set<Integer> set = new HashSet<>();

//        for(int num : nums){
//         set.add(num);
//        }

//         List<Integer> list = new ArrayList<>();
//        for(int i = 1; i<=n; i++){
//         if(!set.contains(i)){
//             list.add(i);
//         }
//        }
//        return list;

//     }
// }

// SOLVING USING CYCLIC SORT IS BEST
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
       int n = nums.length;
       int i = 0;

       while(i < n) {
        int correctIdx = nums[i] -1;

        // sahi index par sahi element hai to loop avoid karne ke liye aage badho
        if(nums[i] != nums[correctIdx]) {
            //swap
            int temp = nums[i];
            nums[i] = nums[correctIdx];
            nums[correctIdx] = temp;
        }else{
            i = i+1;
        }
       }

       List<Integer> list = new ArrayList<>();

        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                list.add(i + 1);
            }
        }

        return list;
       
    }
}