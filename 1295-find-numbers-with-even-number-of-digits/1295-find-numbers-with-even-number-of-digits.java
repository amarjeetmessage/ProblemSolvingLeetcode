class Solution {
    public int findNumbers(int[] nums) {
        int countEvenDigits = 0;

        for (int num : nums) {
            int digitCount = 0;
            int temp = Math.abs(num);

            if (temp == 0) {
                digitCount = 1;
            } else {
                while (temp > 0) {
                    temp /= 10;
                    digitCount++;
                }
            }

            if (digitCount % 2 == 0) {
                countEvenDigits++;
            }
        }
        return countEvenDigits;
    }
}
