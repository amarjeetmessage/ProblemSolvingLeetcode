class Solution {
    List<Integer>[] adj;
    long ans;
    int k;
    int[] values;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        this.k = k;
        this.values = values;
        adj = new ArrayList[n];
        
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        ans = 0;
        dfs(0, -1);
        return (int)ans;
    }

    private long dfs(int node, int parent) {
        long sum = values[node];

        for(int nei : adj[node]) {
            if(nei == parent) continue;
            sum += dfs(nei, node);
        }

        if(sum % k == 0) {
            ans++;     // We can form a valid component
            return 0;  // Cut this subtree from parent
        }

        return sum; // Pass remainder upwards
    }
}


//POTD