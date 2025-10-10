class Solution {

    int i = 0;        // current index
    int sign = 1;     // positive or negative
    long num = 0;     // use long to detect overflow

    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) return 0;
        s = s.trim(); // remove leading/trailing spaces
        return helper(s);
    }

    private int helper(String s) {
        // base case
        if (i >= s.length()) {
            return clamp();
        }

        char c = s.charAt(i);

        // Step 1: handle sign
        if (i == 0 && (c == '+' || c == '-')) {
            sign = (c == '-') ? -1 : 1;
            i++;
            return helper(s);
        }

        // Step 2: if digit → build number
        if (Character.isDigit(c)) {
            num = num * 10 + (c - '0');

            // check overflow
            if (sign * num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign * num < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
            return helper(s);
        }

        // Step 3: non-digit → stop
        return clamp();
    }

    // Clamp result within 32-bit signed integer range
    private int clamp() {
        num = num * sign;
        if (num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) num;
    }
}
