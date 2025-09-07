class Solution {
    public boolean isAnagram(String s, String t) {
        // if lengths are not same, can't be anagram
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency of chars in s
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Subtract frequency using chars in t
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (map.get(ch) != null) {
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
            } else {
                return false;
            }
        }

        // if map empty => all counts matched
        return map.isEmpty();
    }
}
