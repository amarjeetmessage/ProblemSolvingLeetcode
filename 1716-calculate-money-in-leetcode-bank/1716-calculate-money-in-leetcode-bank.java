class Solution {
    public int totalMoney(int n) {
        int total = 0;
        int mondayAmount = 1;

        while (n > 0) {
            // Number of days left in this week (max 7)
            int daysInWeek = Math.min(n, 7);

            // Add this week's total using arithmetic series formula
            total += (2 * mondayAmount + (daysInWeek - 1)) * daysInWeek / 2;

            // Prepare for next week
            mondayAmount++;
            n -= daysInWeek;
        }

        return total;
    }
}
