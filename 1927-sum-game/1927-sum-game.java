class Solution {
    public boolean sumGame(String num) {

        int n = num.length();

        int sum1 = 0, sum2 = 0;
        int count1 = 0, count2 = 0;

        for (int i = 0; i < n / 2; i++) {
            if (num.charAt(i) == '?')
                count1++;
            else
                sum1 += num.charAt(i) - '0';
        }

        for (int i = n / 2; i < n; i++) {
            if (num.charAt(i) == '?')
                count2++;
            else
                sum2 += num.charAt(i) - '0';
        }

        int qDiff = count1 - count2;
        int sumDiff = sum1 - sum2;

        if (qDiff % 2 != 0) {
            return true;
        }

        return sumDiff != -9 * qDiff / 2;
    }
}