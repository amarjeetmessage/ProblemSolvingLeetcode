class Solution {
    public String removeOuterParentheses(String s) {
        int depth = 0;
        StringBuilder str = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch == '('){
                if(depth > 0) str.append('(');
                depth++;
            }
            else{
                depth--;
                if(depth > 0) str.append(')');
                
            }
        }
        return str.toString();
    }
}