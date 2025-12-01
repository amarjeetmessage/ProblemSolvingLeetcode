// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int max = 0;
//         for(int i = 0; i<s.length(); i++) {
//             Set<Character> set = new HashSet<>();

//             for(int j = i; j< s.length(); j++) {
//                 if(set.contains(s.charAt(j))) {
//                     break;
//                 }
//                 set.add(s.charAt(j));
//                 max = Math.max(max, j - i +1);
//             }
//         }
//         return max;
//     }
// }







class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while(j < s.length()) {
            char c = s.charAt(j);
            while(set.contains(c)) {
                set.remove(c);
                i++;
            }
            set.add(c);
            max = Math.max(max, j - i +1);
            j++;
        }
        return max;
    }
}