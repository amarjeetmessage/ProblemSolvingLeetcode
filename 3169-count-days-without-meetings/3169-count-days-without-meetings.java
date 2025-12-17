class Solution {
    public int countDays(int days, int[][] meetings) {
        // 1,2,3,4,5,6,7,8,9,10
        // 1,2,3,5,6,7,9,10
        // 4,8
        // days = 10, meetings = [[1,3],[5,7],[9,10]]
        // sort by start time - done
        // merge intervals in a array - done
        // res array -> calculate gap
        // make sure calculate the start gap and end gap as well
        // T: O(nlogn), S: O(n)

        // days = 10, meetings = [[1,3],[5,7],[9,10]]
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        // sorting playlist... hmm
        List<int[]> res = new ArrayList<>();

        res.add(meetings[0]);
        // days = 10, meetings = [[1,3],[5,7],[9,10]]
        // res = [[1,3],[5,7],[9,10]]
        for (int i = 1; i < meetings.length; i = i + 1) {
            // meetings[i].start <= res.get(res.size() - 1).end
            // merge
            // else meeting -> push it in the result array
            // 1,3
            // 2,4
            // 1,4
            if (meetings[i][0] <= res.get(res.size() - 1)[1]) {
                res.get(res.size() - 1)[0] = Math.min(
                    res.get(res.size() - 1)[0],
                    meetings[i][0]
                );
                res.get(res.size() - 1)[1] = Math.max(
                    res.get(res.size() - 1)[1],
                    meetings[i][1]
                );
            } else {
                res.add(meetings[i]);
            }
        }

        int gap = 0;
        // res = [[2,3],[5,7],[9,9]]
        // gap = 4
        for (int i = 1; i < res.size(); i = i + 1) {
            gap = gap + (res.get(i)[0] - res.get(i - 1)[1]) - 1;
        }

        gap = gap + res.get(0)[0] - 1;
        gap = gap + days - res.get(res.size() - 1)[1];

        return gap;
    }
}
