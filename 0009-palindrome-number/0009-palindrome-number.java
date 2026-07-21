// class Solution {
//     public boolean isPalindrome(int x) {
//         //convert number to string
//         String str = String.valueOf(x);
//         //apply two pointer check from both side for length/2
//         int i = 0;
//         int j = str.length() -1 ;
//         while(i<j) {
//             if(str.charAt(i) != str.charAt(j)) {
//                 return false;
//             }
//             i++;
//             j--;
//         }
//         return true;
//     }
// }




class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int n = s.length();
        
        int start = 0;
        int end = n-1;

        while(start < end) {
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }
}