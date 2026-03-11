class Solution {
    public void dfs(int src, List<List<Integer>> adjList, boolean[] vis) {
        vis[src] = true;
        for(int neigh : adjList.get(src)) {
            if(vis[neigh] == false) {
                dfs(neigh, adjList, vis);
            }
        }
    }
    public int removeStones(int[][] stones) {
        // create adjList
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<stones.length; i++) {
            adjList.add(new ArrayList<>());
        }
        //fill adjList
        for(int i = 0; i<stones.length; i++) {
            for(int j = i+1; j<stones.length; j++) {
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        int components = 0;
        boolean[] vis = new boolean[stones.length];
        for(int i = 0; i<stones.length; i++) {
            if(vis[i] == false) {
                dfs(i,adjList,vis);
                components++;
            }
        }

        return stones.length - components;
    }
}