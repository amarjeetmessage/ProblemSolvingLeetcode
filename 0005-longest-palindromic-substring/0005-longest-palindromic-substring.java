class Solution {
    public boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;

        while(i < j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int len = s.length();
        int maxLen = 1;
        String maxStr = s.substring(0,1);

        for(int i = 0; i<len; i++){
            for(int j = i+1; j<len; j++){
                if(j-i+1 > maxLen && isPalindrome(s.substring(i,j+1))){
                    maxLen = j-i+1;
                    maxStr = s.substring(i,j+1);
                }
            }
        }

        return maxStr;


    }
}