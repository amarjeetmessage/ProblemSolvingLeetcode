class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int n = nums.size();
        int i = 0; 
        int j = n-1;

        nums.sort(null);
        int count = 0;
        while(i<j){
            if(nums.get(i) + nums.get(j) < target){
                count = count + (j-i);
                i++;
            }else{
                j--;
            }
        }
        return count;
    }
}