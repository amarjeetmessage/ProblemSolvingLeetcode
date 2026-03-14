// class Solution {

//     public int minimumTotal(List<List<Integer>> triangle) {
        
//         return solve(triangle, 0, 0);
//     }

//     public int solve(List<List<Integer>> triangle, int row, int col) {

//         if (row == triangle.size() - 1)
//             return triangle.get(row).get(col);

//         int down = solve(triangle, row + 1, col);
//         int diag = solve(triangle, row + 1, col + 1);

//         return triangle.get(row).get(col) + Math.min(down, diag);
//     }
// }







// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int n = triangle.size();
//         int[][] dp = new int[n][];
//         for (int i = 0; i < n; i++) {
//             dp[i] = new int[triangle.get(i).size()];
//             Arrays.fill(dp[i], -1);
//         }

//         return findPathSum(0, 0, triangle, dp);
//     }

//     private int findPathSum(int i, int j, List<List<Integer>> triangle,
//             int[][] dp) {
//         int n = triangle.size();
//         if (i == n - 1) {
//             return dp[i][j] = triangle.get(i).get(j);
//         }
//         if (dp[i][j] != -1)
//             return dp[i][j];
//         int down = triangle.get(i).get(j) + findPathSum(i + 1, j, triangle, dp);
//         int diagonal = triangle.get(i).get(j) + findPathSum(i + 1, j + 1, triangle, dp);

//         return dp[i][j] = Math.min(down, diagonal);
//     }
// }





// //Tabulation....
// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int n = triangle.size(); 
//         int[][] dp = new int[n][];
//         for(int i = 0; i< n; i++){
//             dp[i] = new int[triangle.get(i).size()];
//             Arrays.fill(dp[i], 0);
//         }

//         for(int j = 0; j< n; j++){
//             dp[n-1][j] = triangle.get(n-1).get(j);
//         }

//         for(int i = n-2; i >= 0; i--){
//             for(int j = 0; j<= i; j++){
//                 int down = triangle.get(i).get(j) + dp[i+1][j];
//                 int diagonal = triangle.get(i).get(j) + dp[i+1][j+1];

//                 dp[i][j] = Math.min(down, diagonal);
//             }
//         }
//         return dp[0][0];
//     }
// }






Tabulation with size optimization.....

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] prev = new int[n];
        for(int i = 0; i< n; i++){
            prev[i] = triangle.get(n-1).get(i);
        }

        for(int i = n-2; i>= 0; i--){
            int[] temp = new int[triangle.get(i).size()];
            for(int j = 0; j<= i; j++){
                int down = triangle.get(i).get(j) + prev[j];
                int diagonal = triangle.get(i).get(j) + prev[j+1];
                temp[j] = Math.min(down, diagonal);
            }
            prev = new int[triangle.get(i).size()];
            prev = temp;
        }
        return prev[0];
    }
}