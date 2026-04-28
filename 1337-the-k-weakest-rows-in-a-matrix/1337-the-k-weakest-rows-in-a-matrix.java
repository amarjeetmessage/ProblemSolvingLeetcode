import java.util.*;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        // row -> count, index
        int[][] rowDetails = new int[mat.length][2];

        for (int i = 0; i < mat.length; i++) {

            rowDetails[i][1] = i;

            int countSoldiers = 0;
            int[] row = mat[i];

            for (int ele : row) {
                if (ele == 0) {
                    break;
                }
                countSoldiers = countSoldiers + 1;
            }

            rowDetails[i][0] = countSoldiers;
        }

        // sort based on soldiers count, if same then index
        Arrays.sort(rowDetails, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = rowDetails[i][1];
        }

        return res;
    }
}