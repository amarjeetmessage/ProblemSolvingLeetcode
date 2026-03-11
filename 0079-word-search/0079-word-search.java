class Solution { 
    public boolean fun(int l, String t, int i, int j,
                       char[][] board, String word,
                       int n, int m, int[][] visited) {

        if ((t + board[i][j]).equals(word)) {
            visited[i][j] = 0;
             return true;
        }

        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
        boolean found = false;

        for (int h = 0; h < 4; h++) {
            int ni = i + dir[h][0];
            int nj = j + dir[h][1];

            if (ni >= 0 && nj >= 0 && ni < n && nj < m &&
                visited[ni][nj] == 0 &&
                l + 1 < word.length() &&
                word.charAt(l + 1) == board[ni][nj]) {

                visited[ni][nj] = 1;
                found |= fun(l + 1, t + board[i][j],
                             ni, nj, board, word, n, m, visited);
            }
        }

        visited[i][j] = 0;
        return found;
    }

    public boolean exist(char[][] board, String word) {

        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            int[][] visited = new int[n][m];
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = 1;
                    if (fun(0, "", i, j, board, word, n, m, visited))
                        return true;
                }
            }
        }
        return false;
    }
}




// class Solution {
//     public boolean exist(char[][] board, String word) {
//         int m = board.length;
//         int n = board[0].length;

//         for(int i = 0; i < m; i++) {
//             for(int j = 0; j < n; j++) {
//                 if(board[i][j] == word.charAt(0)) {
//                     if(dfs(board, word, 0, i, j)) {
//                         return true;
//                     }
//                 }
//             }
//         }
//         return false;
//     }

//     private boolean dfs(char[][] board, String word, int idx, int r, int c) {
//         if(idx == word.length()) return true;

//         // Boundary or mismatch or visited check
//         if(r < 0 || c < 0 || r >= board.length || c >= board[0].length
//            || board[r][c] != word.charAt(idx)) {
//             return false;
//         }

//         char temp = board[r][c];
//         board[r][c] = '#';  // mark visited

//         // explore in 4 directions
//         boolean found = dfs(board, word, idx + 1, r + 1, c) ||
//                         dfs(board, word, idx + 1, r - 1, c) ||
//                         dfs(board, word, idx + 1, r, c + 1) ||
//                         dfs(board, word, idx + 1, r, c - 1);

//         board[r][c] = temp; // backtrack

//         return found;
//     }
// }