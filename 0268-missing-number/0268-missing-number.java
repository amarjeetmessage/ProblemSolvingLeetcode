//result sum(using formula of sum of array) - given sum(using inbuilt methods)
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        return (n*(n+1))/2 - Arrays.stream(nums).sum();
    }
}

