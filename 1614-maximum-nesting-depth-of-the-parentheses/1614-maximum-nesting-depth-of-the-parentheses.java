// class Solution {
//     public int maxDepth(String s) {
//         int n = s.length();

//         int count = 0;
//         int max = 0;
//         for(int i = 0; i<n; i++){
//             if(s.charAt(i) == '('){
//                 count++;
//                 max = Math.max(max, count);
//             }
//             else if(s.charAt(i) == ')'){
//                 count--;
//             }
//         }
//         return count;
//     }
// }




class Solution {
    public int maxDepth(String s) {
        int n = s.length();

        int count = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                count++;
                max = Math.max(max, count);
            } else if (s.charAt(i) == ')') {
                count--;
            }
        }

        return max;
    }
}