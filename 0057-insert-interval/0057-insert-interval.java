class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        // insert position... keep inserting intervals in the res - DONE
        // while overlapping...update newInterval
        // no overlapping... insert newInterval into res
        // insert remaining intervals in the res
        int i = 0;

        List<int[]> res = new ArrayList<>();

        // [[1,3],[6,9]]
        //
        // [2,5]
        while (i < intervals.length && newInterval[0] > intervals[i][1]) {
            res.add(intervals[i]);
            i = i + 1;
        }

        // correct position
        // intervals[i][0] - s1
        // intervals[i][1] - e1
        // newInterval[0] - s2
        // newInterval[1] - e2
        // intervals[i][1] >= newInterval[0] && newInterval[1] >= intervals[i][0]
        //
        // [[1,3],[6,9]]
        //
        // [1,5]
        //
        // [1,5],[6,9]
        while (i < intervals.length && (intervals[i][1] >= newInterval[0] && newInterval[1] >= intervals[i][0])) {

            // update newInterval
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);

            i = i + 1;
        }

        res.add(newInterval);

        while (i < intervals.length) {
            res.add(intervals[i]);
            i = i + 1;
        }

        // res -> output
        int[][] ans = new int[res.size()][2];
        // T: O(n), S: O(n)
        for (int j = 0; j < res.size(); j = j + 1) {
            ans[j] = res.get(j);
        }

        return ans;
    }
}
