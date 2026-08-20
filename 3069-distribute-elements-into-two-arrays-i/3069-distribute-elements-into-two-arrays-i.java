class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        int[] ans = new int[n];

        st1.push(nums[0]);
        st2.push(nums[1]);

        for(int i = 2; i<n; i++){
            if(st1.peek() > st2.peek()) {
                st1.push(nums[i]);
            }else{
                st2.push(nums[i]);
            }
        }

        int index = 0;
        for(int x : st1){
            ans[index++] = x;
        }
        for(int y : st2) {
            ans[index++] = y;
        }


        return ans;

    }
}