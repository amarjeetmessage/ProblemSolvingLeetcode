class Solution {
    public boolean isPalindrome(String s) {
         s = s.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
         for(int i = 0 ; i<s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1)){
            return false;
            }
         }
         return true;
    }
}

// replaceAll("[^A-Za-z0-9]", "") → Regex use karke sab non-alphanumeric characters (jo A-Z, a-z, 0-9 nahi hain) remove kar deta hai.