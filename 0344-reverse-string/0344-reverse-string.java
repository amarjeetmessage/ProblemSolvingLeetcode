class Solution {
    public void reverseString(char[] s) {
        
        // ================= Recursive Approach (Uncommented - Ready for Submission) =================
        helper(s, 0, s.length - 1);
    }
    
    // Recursive helper function
    private void helper(char[] s, int left, int right) {
        if (left >= right) return;  // base case: stop when pointers cross
        
        // swap
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        
        // move towards center
        helper(s, left + 1, right - 1);
    }
    
    
    /* ================= Iterative Approach (Commented) =================
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            
            left++;
            right--;
        }
    }
    */
    
    
    /* ================= Using For Loop (Commented) =================
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }
    */
}
