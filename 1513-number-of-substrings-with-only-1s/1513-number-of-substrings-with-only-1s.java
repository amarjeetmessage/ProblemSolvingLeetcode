class Solution {
    public int numSub(String s) {
        //potc
        
        long mod = 1000000007;
        long count = 0, result = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
            } else {
                result = (result + (count * (count + 1) / 2) % mod) % mod;
                count = 0;
            }
        }

        // add last block if ends with 1
        result = (result + (count * (count + 1) / 2) % mod) % mod;

        return (int) result;
    }
}
