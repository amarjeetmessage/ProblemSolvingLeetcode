class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // -------------------------------
        // ✅ Approach 1: Brute Force (O(n^2))
        // Try each station as start, simulate full circle
        // TLE for large input
        /*
        int n = gas.length;
        for (int start = 0; start < n; start++) {
            int tank = 0;
            int count = 0;
            int i = start;
            while (count < n) {
                tank += gas[i] - cost[i];
                if (tank < 0) break;
                i = (i + 1) % n;
                count++;
            }
            if (count == n) return start;
        }
        return -1;
        */

        // -------------------------------
        // ✅ Approach 2: Greedy + Restart if fail (O(n^2))
        // Idea: start at 0, move forward, if tank < 0 restart at next
        // Worst case O(n^2)
        /*
        int n = gas.length;
        int start = 0;
        while (start < n) {
            int tank = 0;
            int count = 0;
            while (count < n) {
                int i = (start + count) % n;
                tank += gas[i] - cost[i];
                if (tank < 0) break;
                count++;
            }
            if (count == n) return start;
            start = start + count + 1;
        }
        return -1;
        */

        // -------------------------------
        // ✅ Approach 3: Greedy Optimal (O(n))
        // Rule: If total gas < total cost → no solution
        // Otherwise, one pass determines start index
        int totalTank = 0, currTank = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            totalTank += gas[i] - cost[i];
            currTank += gas[i] - cost[i];
            if (currTank < 0) {
                // Can't reach i+1, reset start
                start = i + 1;
                currTank = 0;
            }
        }
        return totalTank >= 0 ? start : -1;
    }
}
