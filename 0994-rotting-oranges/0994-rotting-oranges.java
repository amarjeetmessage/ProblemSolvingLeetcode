import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {

        int m = grid.length;      // number of rows
        int n = grid[0].length;   // number of columns

        Queue<int[]> q = new LinkedList<>(); // queue for BFS
        int fresh = 0; // count of fresh oranges

        // Step 1: Find all rotten oranges and count fresh oranges
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if(grid[i][j] == 2){
                    // add rotten oranges to queue
                    q.offer(new int[]{i, j});
                }

                if(grid[i][j] == 1){
                    // count fresh oranges
                    fresh++;
                }
            }
        }

        // if no fresh oranges exist, no time needed
        if(fresh == 0) return 0;

        int time = 0; // minutes passed

        // directions for 4 neighbours (up, down, right, left)
        int dir[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        // Step 2: BFS traversal
        while(!q.isEmpty()){

            int size = q.size(); // current level size

            for(int i = 0; i < size; i++){

                int[] cur = q.poll(); // current rotten orange
                int r = cur[0];
                int c = cur[1];

                // check all 4 directions
                for(int[] d : dir){

                    int nr = r + d[0]; // neighbour row
                    int nc = c + d[1]; // neighbour column

                    // skip if out of grid
                    if(nr < 0 || nc < 0 || nr >= m || nc >= n)
                        continue;

                    // skip if not a fresh orange
                    if(grid[nr][nc] != 1)
                        continue;

                    // make fresh orange rotten
                    grid[nr][nc] = 2;

                    // decrease fresh count
                    fresh--;

                    // add new rotten orange to queue
                    q.offer(new int[]{nr, nc});
                }
            }

            // one BFS level = 1 minute
            time++;
        }

        // if all oranges rotted return time-1 else return -1
        return fresh == 0 ? time - 1 : -1;
    }
}