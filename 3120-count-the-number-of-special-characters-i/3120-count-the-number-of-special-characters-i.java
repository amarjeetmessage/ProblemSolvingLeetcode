import java.util.*;

class Solution {
    public int numberOfSpecialChars(String word) {

        Set<Character> set = new HashSet<>();

        // Store all characters
        for (int i = 0; i < word.length(); i++) {
            set.add(word.charAt(i));
        }

        int count = 0;

        // Check lowercase + uppercase pair
        for (char ch = 'a'; ch <= 'z'; ch++) {

            if (set.contains(ch) && set.contains(Character.toUpperCase(ch))) {
                count++;
            }
        }

        return count;
    }
}