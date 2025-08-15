class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n]; // 0 = uncolored, 1 and -1 are the two colors

        for (int start = 0; start < n; start++) {
            if (color[start] != 0) continue; // already colored

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            color[start] = 1; // start coloring with 1

            while (!queue.isEmpty()) {
                int node = queue.poll();

                for (int neighbor : graph[node]) {
                    if (color[neighbor] == 0) { 
                        color[neighbor] = -color[node]; // opposite color
                        queue.offer(neighbor);
                    } else if (color[neighbor] == color[node]) {
                        return false; // same color found → not bipartite
                    }
                }
            }
        }
        return true; // no conflicts found
    }
}
