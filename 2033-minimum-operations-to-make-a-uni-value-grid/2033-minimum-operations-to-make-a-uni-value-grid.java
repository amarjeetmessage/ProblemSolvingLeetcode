class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int arr[] = new int[m*n];
        int rem = grid[0][0] % x;

        int ind = 0;

        for(int i =0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] % x != rem){
                    return -1;
                }
                arr[ind++] = grid[i][j];
            }
        }
        Arrays.sort(arr);
        int mid = arr.length/2;
        int res = 0;
        for(int i = 0; i<arr.length; i++){
            res += (Math.abs(arr[mid] - arr[i]) / x);
        }
        return res;
    }
}