class Solution {
    public int totalWaviness(int num1, int num2) {
        int plr = num1;
        int count = 0;

        for(int n = plr; n<=num2; n++) {
            count += getwavy(n);
        }

        return count;
    }
    public static int getwavy(int n) {
        String s = String.valueOf(n);
        int wavy = 0;

        if(s.length() < 3) return 0;

        for(int i = 1; i<s.length() -1; i++) {
            int prev = s.charAt(i - 1) - '0';
            int curr = s.charAt(i) - '0';
            int next = s.charAt(i + 1) - '0';

            if(curr>prev && curr>next) wavy++;

            if(curr<prev && curr<next) wavy++;
        }
        return wavy;
    }
}