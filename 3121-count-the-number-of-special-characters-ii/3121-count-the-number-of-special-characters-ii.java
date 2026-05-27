public class Solution {
    public static int numberOfSpecialChars(String word) {
        int n = word.length();
        
     
        int[] firstUpper = new int[26];
        Arrays.fill(firstUpper, -1);
        
       
        int[] lastLower = new int[26];
        Arrays.fill(lastLower, -1);
        
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (Character.isLowerCase(ch)) {
                lastLower[ch - 'a'] = i;
            } else {
                if (firstUpper[ch - 'A'] == -1) {
                    firstUpper[ch - 'A'] = i;
                }
            }
        }
        
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (lastLower[i] != -1 && firstUpper[i] != -1 && lastLower[i] < firstUpper[i]) {
                count++;
            }
        }
        
        return count;
    }


}