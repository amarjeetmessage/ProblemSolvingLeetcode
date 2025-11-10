class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) return true;
                            board[i][j] = '.'; // backtrack
                        }
                    }
                    return false; // no valid number found, trigger backtrack
                }
            }
        }
        return true; // all cells filled
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int k = 0; k < 9; k++) {
            if (board[row][k] == c) return false;         // check row
            if (board[k][col] == c) return false;         // check column
            int boxRow = 3 * (row / 3) + k / 3;
            int boxCol = 3 * (col / 3) + k % 3;
            if (board[boxRow][boxCol] == c) return false; // check box
        }
        return true;
    }
}
