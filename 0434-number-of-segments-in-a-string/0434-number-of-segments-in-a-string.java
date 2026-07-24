
// class Solution {
//     public int countSegments(String s) {
//         int n = s.length();
//         int count = 0;

//         for(int i = 0; i<n; i++) {
//             if(s.charAt(i) != ' ' && (i == 0 ||s.charAt(i-1)== ' ')){
//                 count++;
//             }
//         }

//         return count;
//     }
// }




class Solution {
    public int countSegments(String s) {

        s = s.trim();

        if (s.isEmpty()) {
            return 0;
        }

        String[] ans = s.split("\\s+");

        return ans.length;
    }
}