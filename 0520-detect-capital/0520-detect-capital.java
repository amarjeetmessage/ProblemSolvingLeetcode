class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        int countU = 0;
        int countL = 0;
        for(int i = 0; i<n; i++) {
            if(Character.isUpperCase(word.charAt(i))){
                countU++;
            }
            if(Character.isLowerCase(word.charAt(i))){
                countL++;
            }
        }

        if(countU == n || countL == n){
            return true;
        }

        if(countU == 1 && Character.isUpperCase(word.charAt(0))){
            return true;
        }
        
        return false;

    }
}