class Solution {
    public String reverseWords(String s) {
        // Trim leading/trailing spaces
        s = s.trim();

        int startIndex = s.length() - 1;
        StringBuilder res = new StringBuilder();

        while (startIndex >= 0) {
            // Skip spaces
            while (startIndex >= 0 && s.charAt(startIndex) == ' ') {
                startIndex--;
            }
            if (startIndex < 0) break;

            int endIndex = startIndex;

            // Find the start of the word
            while (startIndex >= 0 && s.charAt(startIndex) != ' ') {
                startIndex--;
            }

            // Add the word
            if (res.length() == 0) {
                res.append(s.substring(startIndex + 1, endIndex + 1));
            } else {
                res.append(" ");
                res.append(s.substring(startIndex + 1, endIndex + 1));
            }
        }

        return res.toString();
    }
}