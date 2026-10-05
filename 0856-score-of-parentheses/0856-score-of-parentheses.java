class Solution {
    public int scoreOfParentheses(String s) {
        int n=s.length();
        Stack<Integer>st=new Stack<>();
        st.push(0);
        
        for(char ch:s.toCharArray()){
            if(ch=='('){
                st.push(0);
            }
            else {
                int curr=st.pop();
                int score;
                if(curr==0){
                    score=1;
                    
                }
                else{
                    score=2*curr;
                    
                }
                st.push(st.pop()+score);
            }
        }
        return st.peek();



    }
}