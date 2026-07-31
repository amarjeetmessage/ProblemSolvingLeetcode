class Solution {
    public int maxEnvelopes(int[][] envelopes) {

        // Sort:
        // 1. Width in ascending order
        // 2. Height in descending order (if widths are equal)
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        List<Integer> temp = new ArrayList<>();
        temp.add(envelopes[0][1]);

        for (int i = 1; i < envelopes.length; i++) {

            int height = envelopes[i][1];
            int index = lowerBound(temp, height);

            if (index == temp.size()) {
                temp.add(height);
            } else {
                temp.set(index, height);
            }
        }

        return temp.size();
    }

    private int lowerBound(List<Integer> list, int target) {
        int low = 0, high = list.size();

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}