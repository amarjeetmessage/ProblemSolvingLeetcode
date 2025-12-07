
// class Solution {
//     public int characterReplacement(String s, int k) {
//         // s = "AABABBA", k = 1

//         int max = 0;

//         // ABCB, k = 1
//         // i   j
//         // max = 3
//         // maxC = 2
//         // B:2, C:1
//         // T: O(n^2), S: O(1)
//         for (int i = 0; i < s.length(); i = i + 1) {
//             int maxC = 0;
//             // A B C D...
//             int[] counts = new int[26];

//             for (int j = i; j < s.length(); j = j + 1) {
//                 char c = s.charAt(j);
//                 // 0,
//                 // 0 -> 'A', 1 -> 'B', 2 -> 'C'
//                 counts[c - 'A'] = counts[c - 'A'] + 1;
//                 maxC = Math.max(maxC, counts[c - 'A']);

//                 // 10.. 6.. 2
//                 int ops = (j - i + 1) - maxC;

//                 if (ops > k) {
//                     break;
//                 }

//                 max = Math.max(max, j - i + 1);
//             }
//         }

//         return max;
//     }
// }






// // class Solution {
// //     public int characterReplacement(String s, int k) {
// //         int max = 0;

// //         for (int i = 0; i < s.length(); i = i + 1) {
// //             int maxC = 0;
// //             int[] counts = new int[26];

// //             for (int j = i; j < s.length(); j = j + 1) {
// //                 char c = s.charAt(j);
// //                 counts[c - 'A'] = counts[c - 'A'] + 1;
// //                 maxC = Math.max(maxC, counts[c - 'A']);

// //                 int ops = (j - i + 1) - maxC;

// //                 if (ops > k) {
// //                     break;
// //                 }

// //                 max = Math.max(max, j - i + 1);
// //             }
// //         }

// //         return max;
// //     }
// // }









class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;

        int i = 0;
        int j = 0;

        int maxC = 0;
        int[] counts = new int[26];

        // ABAB
        // k = 1
        //
        // i
        // max = 3
        // maxC = 2
        // counts = [ A: 4, B: 3 ]
        //
        // T: O(n), S: O(n)
        while (j < s.length()) {
            char c = s.charAt(j);
            counts[c - 'A'] = counts[c - 'A'] + 1;
            maxC = Math.max(maxC, counts[c - 'A']);

            // AAAAAAAA
            //
            // k = 1
            // maxC = 5
            // s = A 5, D 2, 3
            while ((j - i + 1) - maxC > k) {
                char d = s.charAt(i);
                counts[d - 'A'] = counts[d - 'A'] - 1;
                i = i + 1;
            }

            max = Math.max(max, j - i + 1);

            j = j + 1;
        }

        return max;

    }
}










