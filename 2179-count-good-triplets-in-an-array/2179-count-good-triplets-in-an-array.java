// class Solution {
//     public long goodTriplets(int[] nums1, int[] nums2) {
//        int n = nums1.length;

//        int[] pos2 = new int[n];
//         for(int i = 0; i < n; i++) {
//             pos2[nums2[i]] = i;
//         }
        
//         long count = 0;

//          for(int i = 0; i < n; i++) {
//             for(int j = i + 1; j < n; j++) {
//                 for(int k = j + 1; k < n; k++) {

//                     int x = nums1[i];
//                     int y = nums1[j];
//                     int z = nums1[k];
                    
//                     if(pos2[x] < pos2[y] && pos2[y] < pos2[z]) {
//                         count++;
//                     }
//                 }
//             }

//             for(int i = 0; i<n ; i++) {
//                 int y = arr[i]; 
//             }
//         }

//         return count;

//     }
// }






class Solution {

    class BIT {
        int[] tree;
        int n;

        BIT(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        void update(int i, int val) {
            i++; // 1-based indexing
            while (i <= n) {
                tree[i] += val;
                i += i & -i;
            }
        }

        int query(int i) {
            i++; // 1-based indexing
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= i & -i;
            }
            return sum;
        }
    }

    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;

        // Step 1: Map positions
        int[] pos2 = new int[n];
        for (int i = 0; i < n; i++) {
            pos2[nums2[i]] = i;
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = pos2[nums1[i]];
        }

        // Step 2: left count
        BIT bit = new BIT(n);
        int[] left = new int[n];

        for (int i = 0; i < n; i++) {
            left[i] = bit.query(arr[i] - 1);
            bit.update(arr[i], 1);
        }

        // Step 3: right count
        bit = new BIT(n);
        int[] right = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            right[i] = bit.query(n - 1) - bit.query(arr[i]);
            bit.update(arr[i], 1);
        }

        // Step 4: combine
        long count = 0;
        for (int i = 0; i < n; i++) {
            count += (long) left[i] * right[i];
        }

        return count;
    }
}