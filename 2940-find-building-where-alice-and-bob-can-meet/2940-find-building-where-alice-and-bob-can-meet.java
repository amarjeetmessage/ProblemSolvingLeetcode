class Solution {

    static int[] tree;
    // static int[] tree;

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        tree = new int[4 * n];

        // build segment tree
        build(heights, 1, 0, n - 1);

        int q = queries.length;
        int[] res = new int[q];

        for (int i = 0; i < q; i++) {
            int a = queries[i][0];
            int b = queries[i][1];

            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }

            // case 1
            if (a == b) {
                res[i] = a;
                continue;
            }

            // case 2
            if (heights[a] < heights[b]) {
                res[i] = b;
                continue;
            }

            // case 3 → search in right side
            int target = Math.max(heights[a], heights[b]);

            int ans = queryFirstGreater(1, 0, n - 1, b + 1, n - 1, target);

            res[i] = ans;
        }

        return res;
    }

    public static void build(int[] heights, int node, int start, int end) {
        if (start == end) {
            tree[node] = heights[start];
            return;
        }

        int mid = (start + end) / 2;

        build(heights, 2 * node, start, mid);
        build(heights, 2 * node + 1, mid + 1, end);

        tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
    }

    public static int queryFirstGreater(int node, int start, int end, int l, int r, int target) {
        if (end < l || start > r) return -1;

        if (tree[node] <= target) return -1;

        if (start == end) return start;

        int mid = (start + end) / 2;

        int left = queryFirstGreater(2 * node, start, mid, l, r, target);
        if (left != -1) return left;

        return queryFirstGreater(2 * node + 1, mid + 1, end, l, r, target);
    }
}