class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long sum = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                sum += grid[i][j];
            }
        }

        long prefixSum = 0;

        // row-wise
        for(int i = 0; i < m - 1; i++) {
            for(int j = 0; j < n; j++) {
                prefixSum += grid[i][j];
            }

            if(prefixSum == sum - prefixSum) {
                return true;
            }
        }

        // column-wise
        prefixSum = 0;
        for(int j = 0; j < n - 1; j++) {
            for(int i = 0; i < m; i++) {
                prefixSum += grid[i][j];
            }

            if(prefixSum == sum - prefixSum) {
                return true;
            }
        }

        return false;
    }
}