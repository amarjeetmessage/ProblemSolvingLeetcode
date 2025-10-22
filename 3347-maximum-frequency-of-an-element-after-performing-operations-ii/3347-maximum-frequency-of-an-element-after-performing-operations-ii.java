import java.util.*;

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length;
        if (numOperations >= n) return n; // can change all -> freq = n

        // Count occurrences of each original value (existingCount)
        HashMap<Long, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            cnt.put((long)x, cnt.getOrDefault((long)x, 0) + 1);
        }

        // Build event map for interval sweep: +1 at ai-k, -1 at ai+k+1
        TreeMap<Long, Long> events = new TreeMap<>();
        for (int x : nums) {
            long a = (long)x;
            long L = a - (long)k;
            long Rplus = a + (long)k + 1L; // exclusive end
            events.put(L, events.getOrDefault(L, 0L) + 1L);
            events.put(Rplus, events.getOrDefault(Rplus, 0L) - 1L);
        }

        // Build sorted list of all relevant coordinates: event keys and distinct ai
        TreeSet<Long> coordinates = new TreeSet<>();
        coordinates.addAll(events.keySet());
        coordinates.addAll(cnt.keySet());

        long curr = 0L;
        long maxCoverage = 0L;
        // For coverage at exact ai values
        HashMap<Long, Long> coverageAt = new HashMap<>();

        Iterator<Long> it = coordinates.iterator();
        while (it.hasNext()) {
            long coord = it.next();
            // apply all events at this coord if any
            Long delta = events.get(coord);
            if (delta != null) curr += delta;
            // curr is now coverage at 'coord'
            if (curr > maxCoverage) maxCoverage = curr;
            if (cnt.containsKey(coord)) {
                coverageAt.put(coord, curr);
            }
        }

        int ans = 1;
        // Candidate from any v (not necessarily original): cap by numOperations
        ans = Math.max(ans, (int)Math.min(maxCoverage, (long)numOperations));

        // Candidates where v is some existing ai (can use existingCount)
        for (Map.Entry<Long, Integer> e : cnt.entrySet()) {
            long val = e.getKey();
            int existing = e.getValue();
            long cov = coverageAt.getOrDefault(val, 0L);
            long candidate = Math.min(cov, (long)existing + (long)numOperations);
            if ((int)candidate > ans) ans = (int)candidate;
        }

        // Also, if numOperations == 0, answer must be max duplicate count (covered above)
        // But to be safe, include existing max duplicates:
        int maxDup = 0;
        for (int v : cnt.values()) if (v > maxDup) maxDup = v;
        ans = Math.max(ans, maxDup);

        return ans;
    }
}
