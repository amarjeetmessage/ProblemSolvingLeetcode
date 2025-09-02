class Solution {
    public String largestOddNumber(String num) {
        int len = num.length() - 1;  // Start from the last character
        
        while (len >= 0) {
            int d = num.charAt(len) - '0';  // Convert char to integer
            
            if (d % 2 != 0) {  // Check if it's odd
                return num.substring(0, len + 1);  // Return substring till this index
            }
            
            len--;  // Move left
        }
        
        return "";  // If no odd number found, return empty string
    }
}