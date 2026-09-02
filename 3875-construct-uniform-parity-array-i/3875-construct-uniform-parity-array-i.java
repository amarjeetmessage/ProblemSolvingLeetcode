class Solution {
    public boolean uniformArray(int[] nums1) {
        if(nums1.length == 1) return true;
        int even = 0;
        int odd = 0;

        for(int n : nums1) {
            if(n % 2 == 0) even++;
            else odd++;
        }
        
        boolean allEven = (even >= 1 || odd >= 2);
        boolean allOdd = (even>=1 && odd>= 1);

        return allEven || allOdd;
    }
}