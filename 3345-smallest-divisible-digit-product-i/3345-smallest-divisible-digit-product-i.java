class Solution {

    public int findProduct(int n) {
        int prod = 1;

        while (n > 0) {
            prod *= (n % 10);
            n /= 10;
        }

        return prod;
    }

    public int smallestNumber(int n, int t) {

        while (true) {
            int product = findProduct(n);

            if (product % t == 0) {
                return n;
            }

            n++;
        }
    }
}