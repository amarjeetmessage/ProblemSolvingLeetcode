class Solution {
    public int findNumbers(int[] nums) {
        int countEvenDigits = 0; // Count of numbers with even number of digits

        for (int num : nums) {
            int digitCount = 0;
            int temp = Math.abs(num); // Handle negative numbers

            // Special case: 0 has 1 digit
            if (temp == 0) {
                digitCount = 1;
            } else {
                // Count digits by dividing by 10 repeatedly
                while (temp > 0) {
                    temp /= 10;
                    digitCount++;
                }
            }

            // If digit count is even, increase the result counter
            if (digitCount % 2 == 0) {
                countEvenDigits++;
            }
        }

        return countEvenDigits; // Return total count
    }
}
