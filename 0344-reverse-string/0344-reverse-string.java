class Solution {
    public void reverseString(char[] s) {
        
        // ================= Iterative Two-Pointer Approach (Uncommented - Ready for Submission) =================
        int left = 0, right = s.length - 1;
        
        while (left < right) {
            // swap
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            
            left++;
            right--;
        }
    }
    
    
    /* ================= Recursive Approach (Commented) =================
    public void reverseString(char[] s) {
        helper(s, 0, s.length - 1);
    }
    
    private void helper(char[] s, int left, int right) {
        if (left >= right) return;
        
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        
        helper(s, left + 1, right - 1);
    }
    */
    
    
    /* ================= For Loop Swap Approach (Commented) =================
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }
    */
}
