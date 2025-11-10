// class Solution {

//     public static boolean isSafe(int board[i][j], int i, int j) {
//         for(int i = 0; i< row; i++){
//             if(board[i][col] == 'Q') return false;
// 0       }
//         for(int i = row-1 ||int j = col-1; i>=0 || j >= 0; i--,j--) {
//             if(board[i][j] == 'Q') return false;
//         }
//         for(int i = row-1 || int j = col+1; i >= 0 && j<n; i-- , j++) {
//             if(board[i][j] == 'Q') return false;
//         }
//         return true;
//     }
//     public static void solve(int n, int[][] board, int row, int col) {
//         //base case
//         if(i == n) {
//             System.out.print(baord);
//             return ;
//         }

//         for(int j = 0; j < board[0].length; j++) {
//             if(isSafe(board[i][j])) {
//                 board[i][j] = 'Q';
//             }
//         }
//         solve(n, baord, row+1);
//     }
//     public List<List<String>> solveNQueens(int n) {
//         return solve(n,new int[][] board,0,0);
//     }
// }


class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        solve(0, board, n);
        return ans;
    }

    private void solve(int row, char[][] board, int n) {
        if (row == n) {
            ans.add(construct(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                solve(row + 1, board, n);
                board[row][col] = '.'; // backtrack
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col, int n) {
        for (int i = 0; i < row; i++) 
            if (board[i][col] == 'Q') return false;

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) 
            if (board[i][j] == 'Q') return false;

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) 
            if (board[i][j] == 'Q') return false;

        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) res.add(new String(row));
        return res;
    }
}
