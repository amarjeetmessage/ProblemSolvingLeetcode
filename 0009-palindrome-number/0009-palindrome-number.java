class Solution {
    public boolean isPalindrome(int x) {
        //convert number to string
        String str = String.valueOf(x);
        //apply two pointer check from both side for length/2
        int i = 0;
        int j = str.length() -1 ;
        while(i<j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}