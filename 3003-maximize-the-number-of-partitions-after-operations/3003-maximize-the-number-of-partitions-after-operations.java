//HARD POTD

class Solution {
    private Map<Long, Integer> memo = new HashMap<>();
    private String s;
    private int k;
    private int n;
    
    public int maxPartitionsAfterOperations(String s, int k) {
        this.s = s;
        this.k = k;
        this.n = s.length();
        return solve(0, 0, false);
    }
    
    private int solve(int i, int mask, boolean changed) {
        if (i == n) {
            return mask == 0 ? 0 : 1; // Count last partition if exists
        }
        
        long key = ((long)i << 27) | ((long)mask << 1) | (changed ? 1 : 0);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        int cur = s.charAt(i) - 'a';
        int curMask = 1 << cur;
        int ans = 0;
        
        // Don't change current character
        if (Integer.bitCount(mask | curMask) <= k) {
            // Can add to current partition
            ans = solve(i + 1, mask | curMask, changed);
        } else {
            // Must start new partition
            ans = 1 + solve(i + 1, curMask, changed);
        }
        
        // Try changing current character
        if (!changed) {
            for (int newChar = 0; newChar < 26; newChar++) {
                if (newChar == cur) continue;
                int newMask = 1 << newChar;
                
                if (Integer.bitCount(mask | newMask) <= k) {
                    // Can add changed char to current partition
                    ans = Math.max(ans, solve(i + 1, mask | newMask, true));
                } else {
                    // Must start new partition with changed char
                    ans = Math.max(ans, 1 + solve(i + 1, newMask, true));
                }
            }
        }
        
        memo.put(key, ans);
        return ans;
    }
}