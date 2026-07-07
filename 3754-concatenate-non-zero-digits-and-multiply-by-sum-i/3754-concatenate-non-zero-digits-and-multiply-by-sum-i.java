class Solution {
    public long sumAndMultiply(int n) {

        String s = String.valueOf(n);
        StringBuilder sb = new StringBuilder();

        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                sb.append(s.charAt(i));
                sum += s.charAt(i) - '0';
            }
        }

        if (sb.length() == 0) {
            return 0;
        }

        int digit = Integer.parseInt(sb.toString());

        return (long) digit * sum;
    }
}