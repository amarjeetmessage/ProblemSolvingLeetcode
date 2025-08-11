class TreeAncestor {
    int[][] up; // up[v][j] = 2^j-th ancestor of v
    int LOG;    // max power of two needed

    public TreeAncestor(int n, int[] parent) {
        LOG = (int) (Math.log(n) / Math.log(2)) + 1;
        up = new int[n][LOG];

        // Initialize direct parent (2^0 ancestor)
        for (int i = 0; i < n; i++) {
            up[i][0] = parent[i];
        }

        // Precompute 2^j-th ancestors
        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                if (up[i][j - 1] != -1) {
                    up[i][j] = up[ up[i][j - 1] ][j - 1];
                } else {
                    up[i][j] = -1;
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for (int j = 0; j < LOG; j++) {
            if (((k >> j) & 1) == 1) { // if j-th bit is set
                node = up[node][j];
                if (node == -1) return -1;
            }
        }
        return node;
    }
}


/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */