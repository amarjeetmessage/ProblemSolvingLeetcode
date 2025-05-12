class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = m - 1;

        while (ans.size() < m * n) {
            // Left to Right
            for (int i = left; i <= right && ans.size() < m * n; i++) {
                ans.add(matrix[top][i]);
            }
            top++;

            // Top to Bottom
            for (int i = top; i <= bottom && ans.size() < m * n; i++) {
                ans.add(matrix[i][right]);
            }
            right--;

            // Right to Left
            for (int i = right; i >= left && ans.size() < m * n; i--) {
                ans.add(matrix[bottom][i]);
            }
            bottom--;

            // Bottom to Top
            for (int i = bottom; i >= top && ans.size() < m * n; i--) {
                ans.add(matrix[i][left]);
            }
            left++;
        }

        return ans;
    }
}
