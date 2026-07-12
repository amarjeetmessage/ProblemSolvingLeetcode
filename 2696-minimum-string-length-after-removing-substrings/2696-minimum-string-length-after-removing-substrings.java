class Solution {
    public int minLength(String s) {
        int n = s.length();

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<n; i++) {
            char c = s.charAt(i);

            if(!stack.isEmpty() && c == 'B' && stack.peek() == 'A'){
                stack.pop();
            }else if(!stack.isEmpty() && c == 'D' && stack.peek() == 'C'){
                stack.pop();
            }else{
                stack.push(c);
            }
        }

        return stack.size();
    }
}