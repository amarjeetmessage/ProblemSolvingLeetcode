//BRUTE FORCE APPROACH

// class Solution {
//     public int[] kWeakestRows(int[][] mat, int k) {
//         // row -> count, index
//         int[][] rowDetails = new int[mat.length][2];

//         for (int i = 0; i < mat.length; i++) {

//             rowDetails[i][1] = i;

//             int countSoldiers = 0;
//             int[] row = mat[i];

//             for (int ele : row) {
//                 if (ele == 0) {
//                     break;
//                 }
//                 countSoldiers = countSoldiers + 1;
//             }

//             rowDetails[i][0] = countSoldiers;
//         }

//         // sort based on soldiers count, if same then index
//         Arrays.sort(rowDetails, (a, b) -> {
//             if (a[0] == b[0]) {
//                 return a[1] - b[1];
//             }
//             return a[0] - b[0];
//         });

//         int[] res = new int[k];

//         for (int i = 0; i < k; i++) {
//             res[i] = rowDetails[i][1];
//         }

//         return res;
//     }
// }




//USING BINARY SEARCH APPROACH 
import java.util.*;

class Solution {

    // 0 1 2 3 4
    // 1 1 1 1
    //       h
    //   m
    public int binarySearch(int[] arr) {
        // first 0 ki talaash hai
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == 1) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return arr[low] == 1 ? arr.length : low;
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        // row -> count, index
        int[][] rowDetails = new int[mat.length][2];

        // [2:0], [4:1], [1:2]

        // n rows
        // m columns
        // T: O(n + n(log m)), S: O(n)

        for (int i = 0; i < mat.length; i = i + 1) {
            // [1,1,0,0,0]
            rowDetails[i][0] = binarySearch(mat[i]);
            rowDetails[i][1] = i;
        }

        // [[2:0], [4:1], [1:2], [2:3], [5:4]]
        // sort this array based on soldiers count
        // if count of soldiers is same then sort them based on indexes
        // T: O(n(log n)), S: O(n)

        Arrays.sort(rowDetails, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        // [[1:2], [2:0], [2:3], [4:1], [5:4]]

        int[] res = new int[k];

        for (int i = 0; i < k; i = i + 1) {
            res[i] = rowDetails[i][1];
        }

        return res;
    }
}