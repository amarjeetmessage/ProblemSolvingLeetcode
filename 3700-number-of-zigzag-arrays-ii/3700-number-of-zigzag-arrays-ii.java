class Solution {
        static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {

        int m = r - l + 1;

        // Transition matrix:
        // next[i] = sum of last i elements of cur
        long[][] trans = new long[m][m];
        for (int i = 1; i < m; i++) {
            for (int j = m - i; j < m; j++) {
                trans[i][j] = 1;
            }
        }

        // Base for length 2: up[i] = i
        long[] vec = new long[m];
        for (int i = 0; i < m; i++) {
            vec[i] = i;
        }

        long exp = n - 2;
        long[][] power = trans;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                vec = multiply(power, vec);
            }
            power = multiply(power, power);
            exp >>= 1;
        }

        long sum = 0;
        for (long x : vec) {
            sum = (sum + x) % MOD;
        }

        return (int)((2 * sum) % MOD);
    }

    private long[] multiply(long[][] mat, long[] vec) {
        int m = mat.length;
        long[] res = new long[m];

        for (int i = 0; i < m; i++) {
            long s = 0;
            for (int j = 0; j < m; j++) {
                if (mat[i][j] != 0) {
                    s = (s + mat[i][j] * vec[j]) % MOD;
                }
            }
            res[i] = s;
        }

        return res;
    }

    private long[][] multiply(long[][] a, long[][] b) {
        int m = a.length;
        long[][] res = new long[m][m];

        for (int i = 0; i < m; i++) {
            for (int k = 0; k < m; k++) {
                if (a[i][k] == 0) continue;
                long aik = a[i][k];
                for (int j = 0; j < m; j++) {
                    if (b[k][j] == 0) continue;
                    res[i][j] = (res[i][j] + aik * b[k][j]) % MOD;
                }
            }
        }

        return res;
    }
}