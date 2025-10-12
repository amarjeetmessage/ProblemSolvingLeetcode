//POTD
import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int magicalSum(int m, int k, int[] nums) {
        int n = nums.length;

        // 1) precompute powVal[pos][cnt] = nums[pos]^cnt % MOD, cnt in [0..m]
        long[][] powVal = new long[n][m + 1];
        for (int i = 0; i < n; i++) {
            powVal[i][0] = 1;
            long base = nums[i] % MOD;
            for (int cnt = 1; cnt <= m; cnt++) {
                powVal[i][cnt] = (powVal[i][cnt - 1] * base) % MOD;
            }
        }

        // 2) precompute binomial coefficients C[a][b] for 0 <= a,b <= m
        long[][] C = new long[m + 1][m + 1];
        for (int i = 0; i <= m; i++) {
            C[i][0] = C[i][i] = 1;
            for (int j = 1; j < i; j++) {
                C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % MOD;
            }
        }

        // dp[used][carry][bits] => sum of products * combinatorial placements so far
        long[][][] dp = new long[m + 1][m + 1][k + 1];
        dp[0][0][0] = 1L; // no picks, no carry, no bits, product=1 (neutral)

        for (int pos = 0; pos < n; pos++) {
            long[][][] next = new long[m + 1][m + 1][k + 1];

            for (int used = 0; used <= m; used++) {
                for (int carry = 0; carry <= m; carry++) {
                    for (int bits = 0; bits <= k; bits++) {
                        long cur = dp[used][carry][bits];
                        if (cur == 0) continue;

                        int remain = m - used; // remaining picks we can allocate

                        // try picking cnt times this index (0..remain)
                        for (int cnt = 0; cnt <= remain; cnt++) {
                            int newUsed = used + cnt;
                            int total = carry + cnt;
                            int newCarry = total / 2;
                            int addBit = total % 2;
                            int newBits = bits + addBit;
                            if (newCarry > m) continue; // carry too big
                            if (newBits > k) {
                                // Increasing cnt further will not decrease newBits,
                                // but it could change carry causing later bits; still we can continue,
                                // however since newBits already > k this branch can't lead to valid final (prune)
                                continue;
                            }

                            // Ways to place these cnt picks among 'remain' positions:
                            long waysToPlace = C[remain][cnt];

                            // Contribution: previous value * ways to place * nums[pos]^cnt
                            long contrib = cur;
                            contrib = (contrib * waysToPlace) % MOD;
                            contrib = (contrib * powVal[pos][cnt]) % MOD;

                            next[newUsed][newCarry][newBits] = (next[newUsed][newCarry][newBits] + contrib) % MOD;
                        }
                    }
                }
            }

            dp = next; // move to next index/bit position
        }

        // After processing all positions, take only states where used == m
        long ans = 0;
        for (int carry = 0; carry <= m; carry++) {
            int pop = Integer.bitCount(carry); // bits contributed by remaining carry
            for (int bits = 0; bits <= k; bits++) {
                if (bits + pop == k) {
                    ans = (ans + dp[m][carry][bits]) % MOD;
                }
            }
        }

        return (int) ans;
    }
}

