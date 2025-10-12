class Solution {
    public int longestSubarray(int[] nums) {
        int[] arr = nums;

        int n = arr.length;
        if(n<=2) return n;

        int maxLen = 2;
        int currLen = 2;

        for(int i = 2; i<n; i++){
            if(arr[i] == arr[i-1] + arr[i-2]){
                currLen++;
            }else{
                currLen = 2;
            }
            maxLen = Math.max(maxLen, currLen);
        }
        return maxLen;
    }
}