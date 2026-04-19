 class Solution {
    public void reverseString(char[] s) {
       int len = s.length;
       int i = 0;
       int j = len - 1;
       
       //apply while loop
       while(i<j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;

        i+=1;
        j-=1;
       }
    }
}