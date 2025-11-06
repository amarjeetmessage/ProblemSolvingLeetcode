class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) return ans;

        String[] mapping = {
            "", "", "abc",
            "def", "ghi", "jkl",
            "mno", "pqrs", "tuv",
            "wxyz"
        };

        backtrack(digits, 0, new StringBuilder(), ans, mapping);
        return ans;
    }

    private void backtrack(String digits, int index, StringBuilder curr, List<String> ans, String[] mapping) {
        if (index == digits.length()) {
            ans.add(curr.toString());
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            curr.append(c);
            backtrack(digits, index + 1, curr, ans, mapping);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
