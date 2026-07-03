class Solution {
    public int firstMissingPositive(int[] nums) {

        TreeSet<Integer> set = new TreeSet<>();

        // Store only positive numbers
        for (int num : nums) {
            if (num > 0)
                set.add(num);
        }

        // Check from 1 onwards
        int expected = 1;

        for (int num : set) {

            if (num == expected)
                expected++;

            else if (num > expected)
                return expected;
        }

        return expected;
    }
}