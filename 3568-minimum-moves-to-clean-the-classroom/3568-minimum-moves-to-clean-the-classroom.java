class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int[][] litterIndex = new int[m][n];

        // Initialize with -1
        for (int i = 0; i < m; i++) {
            Arrays.fill(litterIndex[i], -1);
        }

        int startRow = 0;
        int startCol = 0;
        int litterCount = 0;

        // Find S and assign index to every L
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char cell = classroom[i].charAt(j);

                if (cell == 'S') {
                    startRow = i;
                    startCol = j;
                }

                if (cell == 'L') {
                    litterIndex[i][j] = litterCount;
                    litterCount++;
                }
            }
        }

        int totalMask = (1 << litterCount) - 1;

        Queue<State> queue = new LinkedList<>();

        boolean[][][][] visited =
            new boolean[m][n][energy + 1][1 << litterCount];

        queue.offer(
            new State(startRow, startCol, energy, 0, 0)
        );

        visited[startRow][startCol][energy][0] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            State curr = queue.poll();

            // All litter collected
            if (curr.mask == totalMask) {
                return curr.moves;
            }

            for (int d = 0; d < 4; d++) {

                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];

                // Invalid position
                if (nr < 0 || nr >= m ||
                    nc < 0 || nc >= n) {
                    continue;
                }

                // Obstacle
                if (classroom[nr].charAt(nc) == 'X') {
                    continue;
                }

                // Need energy to move
                if (curr.energyLeft == 0) {
                    continue;
                }

                int newEnergy = curr.energyLeft - 1;
                int newMask = curr.mask;

                // Collect litter
                if (litterIndex[nr][nc] != -1) {
                    newMask |= (1 << litterIndex[nr][nc]);
                }

                // Reset energy
                if (classroom[nr].charAt(nc) == 'R') {
                    newEnergy = energy;
                }

                if (!visited[nr][nc][newEnergy][newMask]) {

                    visited[nr][nc][newEnergy][newMask] = true;

                    queue.offer(
                        new State(
                            nr,
                            nc,
                            newEnergy,
                            newMask,
                            curr.moves + 1
                        )
                    );
                }
            }
        }

        return -1;
    }


    class State {

        int r, c;
        int energyLeft;
        int mask;
        int moves;

        State(int r, int c, int energyLeft,
              int mask, int moves) {

            this.r = r;
            this.c = c;
            this.energyLeft = energyLeft;
            this.mask = mask;
            this.moves = moves;
        }
    }
}//potd