class Solution {
    public int[] separateDigits(int[] nums) {

        ArrayList<Integer> temp = new ArrayList<>();

        for (int num : nums) {

            ArrayList<Integer> digits = new ArrayList<>();

            while (num > 0) {
                digits.add(num % 10);
                num /= 10;
            }

            for (int i = digits.size() - 1; i >= 0; i--) {
                temp.add(digits.get(i));
            }
        }

        int[] ans = new int[temp.size()];

        for (int i = 0; i < temp.size(); i++) {
            ans[i] = temp.get(i);
        }

        return ans;
    }
}