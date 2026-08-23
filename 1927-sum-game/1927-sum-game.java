// class Solution {
//     public boolean sumGame(String num) {

//         int n = num.length();

//         int sum1 = 0, sum2 = 0;
//         int count1 = 0, count2 = 0;

//         for (int i = 0; i < n / 2; i++) {
//             if (num.charAt(i) == '?') {
//                 count1++;
//             } else {
//                 sum1 += num.charAt(i) - '0';
//             }
//         }

//         for (int i = n / 2; i < n; i++) {
//             if (num.charAt(i) == '?') {
//                 count2++;
//             } else {
//                 sum2 += num.charAt(i) - '0';
//             }
//         }

//         int diff = sum1 - sum2;
//         int countDiff = count1 - count2;

//         // Alice wins if she can force an unequal sum
//         if ((countDiff % 2 != 0)) {
//             return true;
//         }

//         return diff != (countDiff / 2) * 9;
//     }
// }









class Solution {
    public boolean sumGame(String num) {

        int n = num.length();

        int sum1 = 0, sum2 = 0;
        int q1 = 0, q2 = 0;

        for (int i = 0; i < n / 2; i++) {
            if (num.charAt(i) == '?')
                q1++;
            else
                sum1 += num.charAt(i) - '0';
        }

        for (int i = n / 2; i < n; i++) {
            if (num.charAt(i) == '?')
                q2++;
            else
                sum2 += num.charAt(i) - '0';
        }

        int qDiff = q1 - q2;
        int sumDiff = sum1 - sum2;

        if (qDiff % 2 != 0) {
            return true;
        }

        return sumDiff != -9 * qDiff / 2;
    }
}