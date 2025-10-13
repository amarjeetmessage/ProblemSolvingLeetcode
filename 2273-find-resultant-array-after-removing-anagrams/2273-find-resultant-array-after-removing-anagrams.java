import java.util.*;

class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        result.add(words[0]); // Always keep the first word
        
        for (int i = 1; i < words.length; i++) {
            // Compare current word with previous word
            if (!isAnagram(words[i], words[i - 1])) {
                result.add(words[i]);
            }
        }
        
        return result;
    }

    // Helper method to check if two words are anagrams
    private boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        return Arrays.equals(arr1, arr2);
    }
}
