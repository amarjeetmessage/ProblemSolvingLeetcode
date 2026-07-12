class Solution {
    public boolean isValid(String s) {
        int n = s.length();

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<n; i++){
            char c = s.charAt(i);
            
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }else if(!stack.isEmpty() && c == ')' && stack.peek() == '('){
                stack.pop();
            }
            else if(!stack.isEmpty() && c == '}' && stack.peek() == '{'){
                stack.pop();
            }
            else if(!stack.isEmpty() && c == ']' && stack.peek() == '['){
                stack.pop();
            }
            else{
                return false;
            }
        }

        if(stack.isEmpty()){
           return true; 
        }else return false;
    }
}