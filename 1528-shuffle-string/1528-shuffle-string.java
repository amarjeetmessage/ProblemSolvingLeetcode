class Solution {
    public String restoreString(String s, int[] indices) {
        // Ek nayi character array bana rahe hain jisme hum final answer store karenge
        char[] result = new char[s.length()];

        // Har character ke liye loop chalate hain
        for (int i = 0; i < s.length(); i++) {
            // s.charAt(i) se current character lete hain
            // indices[i] batata hai ki ye character final string me kahan jayega
            // Us position par result array me character daal dete hain
            result[indices[i]] = s.charAt(i);
        }

        // result char array ko String me convert karke return kar dete hain
        return new String(result);
    }
}
