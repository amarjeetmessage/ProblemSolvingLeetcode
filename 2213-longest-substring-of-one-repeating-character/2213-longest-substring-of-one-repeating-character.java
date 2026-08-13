class Solution {

    TreeMap<Integer, Integer> map = new TreeMap<>();
    TreeMap<Integer, Integer> freq = new TreeMap<>();

    public int[] longestRepeating(
        String s,
        String queryCharacters,
        int[] queryIndices
    ) {

        int n = s.length();
        char[] arr = s.toCharArray();

        // Build intervals
        int start = 0;

        for (int i = 1; i <= n; i++) {

            if (i == n || arr[i] != arr[i - 1]) {

                map.put(start, i - 1);
                addLength(i - start);

                start = i;
            }
        }

        int[] ans = new int[queryIndices.length];

        for (int q = 0; q < queryIndices.length; q++) {

            int idx = queryIndices[q];
            char ch = queryCharacters.charAt(q);

            // No change
            if (arr[idx] == ch) {
                ans[q] = freq.lastKey();
                continue;
            }

            // Find interval containing idx
            int left = map.floorKey(idx);
            int right = map.get(left);

            int oldLength = right - left + 1;

            removeLength(oldLength);
            map.remove(left);

            /*
             * Split old interval into:
             *
             * [left ... idx-1]
             * [idx]
             * [idx+1 ... right]
             */

            if (left <= idx - 1) {
                map.put(left, idx - 1);
                addLength(idx - left);
            }

            if (idx + 1 <= right) {
                map.put(idx + 1, right);
                addLength(right - idx);
            }

            arr[idx] = ch;

            /*
             * Now create interval [idx, idx]
             */
            map.put(idx, idx);
            addLength(1);

            /*
             * Merge with left interval if same character
             */
            if (idx > 0 && arr[idx - 1] == arr[idx]) {

                int leftStart = map.floorKey(idx - 1);
                int leftEnd = map.get(leftStart);

                removeLength(leftEnd - leftStart + 1);
                removeLength(1);

                map.remove(leftStart);
                map.remove(idx);

                map.put(leftStart, idx);

                addLength(idx - leftStart + 1);
            }

            /*
             * Merge with right interval if same character
             */
            if (idx + 1 < n && arr[idx + 1] == arr[idx]) {

                int currentStart = map.floorKey(idx);
                int currentEnd = map.get(currentStart);

                int rightStart = map.higherKey(currentStart);
                int rightEnd = map.get(rightStart);

                removeLength(currentEnd - currentStart + 1);
                removeLength(rightEnd - rightStart + 1);

                map.remove(currentStart);
                map.remove(rightStart);

                map.put(currentStart, rightEnd);

                addLength(rightEnd - currentStart + 1);
            }

            ans[q] = freq.lastKey();
        }

        return ans;
    }

    void addLength(int len) {
        freq.put(
            len,
            freq.getOrDefault(len, 0) + 1
        );
    }

    void removeLength(int len) {

        int count = freq.get(len);

        if (count == 1) {
            freq.remove(len);
        } else {
            freq.put(len, count - 1);
        }
    }
}

// potd