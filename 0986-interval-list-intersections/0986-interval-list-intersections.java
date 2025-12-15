class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        // 1,2,3
        // 2,3,4
        // [[0,2],[5,10],[13,23],[24,25]]
        // List<int[]> res = new ArrayList<>();

        // 1,2,3, 5,6,7,8,9
        //     j
        // 2,3,4,5
        // res = [[2,3],[5,5]]
        int i = 0;
        int j = 0;

        // T: O(m + n), S: O(m + n)
        while (i < firstList.length && j < secondList.length) {
            // intersection??
            // e1 >= s2 && e2 >= s1
            int e1 = firstList[i][1],
                e2 = secondList[j][1],
                s1 = firstList[i][0],
                s2 = secondList[j][0];

            if (e1 >= s2 && e2 >= s1) {
                res.add(new int[] {
                    Math.max(s1, s2),
                    Math.min(e1, e2)
                });
            }

            // 1,2,3,4,5,6,7
            // 2,3,4,5,6,7,8,9
            if (e1 < e2) {
                i = i + 1;
            } else {
                // e1 == e2
                j = j + 1;
            }
        }

        int[][] ans = new int[res.size()][2];

        for (int k = 0; k < res.size(); k = k + 1) {
            ans[k] = res.get(k);
        }

        return ans;
    }
}

// A me aage badhna hai ki B me aage badhna hai ye kaun pahle khatam ho rha hai (end time) dekh ke pta chalega 

