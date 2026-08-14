class Solution {

    public int maximumLengthSubstring(String s) {
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {

                String sub = s.substring(i, j + 1);

                if (isValid(sub)) {
                    max = Math.max(max, sub.length());
                }
            }
        }

        return max;
    }

    public boolean isValid(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if (map.get(ch) > 2)
                return false;
        }

        return true;
    }
}