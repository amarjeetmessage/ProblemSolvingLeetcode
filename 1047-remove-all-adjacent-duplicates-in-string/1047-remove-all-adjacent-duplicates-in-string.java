// class Solution {
//     public String removeDuplicates(String s) {

//         StringBuilder sb = new StringBuilder();

//         for (char ch : s.toCharArray()) {

//             int len = sb.length();

//             if (len > 0 && sb.charAt(len - 1) == ch) {
//                 sb.deleteCharAt(len - 1);   // Pop
//             } else {
//                 sb.append(ch);              // Push
//             }}

//         return sb.toString();
//     }
// }



class Solution {
    public String removeDuplicates(String s) {

        /*
        PSEDO CODE

        stack of character
        iterate through the string
        if(stack last char is equal to current char) then remove from stack otherwise push current char

        keep popping ftome stack till it is empty and add it to a stringBuilder 

        reverse stringbuilder and return as ans
        */

        int n = s.length();
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n; i++) {
            if(!st.isEmpty() && st.peek() == s.charAt(i)){
                st.pop();
            }else{
                st.push(s.charAt(i));
            }
        }

        while(!st.isEmpty()) {
            sb.append(st.pop());
        }

        // reverse StringBuilder sb 
        return sb.reverse().toString();
    }
}