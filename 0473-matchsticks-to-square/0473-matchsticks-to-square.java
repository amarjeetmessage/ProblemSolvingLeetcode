class Solution {
    public boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length;
        
        // Step 1: total sum
        int total = 0;
        for (int stick : matchsticks) {
            total += stick;
        }

        // Step 2: check divisibility
        if (total % 4 != 0) return false;

        int target = total / 4;

        // Step 3: sort in descending order
        Arrays.sort(matchsticks);
        reverse(matchsticks);  // custom reverse

        // Step 4: create 4 sides
        int[] sides = new int[4];

        // Step 5: start DFS
        return dfs(matchsticks, 0, sides, target);
    }

    private boolean dfs(int[] matchsticks, int index, int[] sides, int target) {
        // Base case: all sticks used
        if (index == matchsticks.length) {
            return true;
        }

        int stick = matchsticks[index];

        // Try placing in all 4 sides
        for (int i = 0; i < 4; i++) {

            // Skip if exceeds target
            if (sides[i] + stick > target) continue;

            // Skip duplicate states
            if (i > 0 && sides[i] == sides[i - 1]) continue;

            // Place stick
            sides[i] += stick;

            // Recurse
            if (dfs(matchsticks, index + 1, sides, target)) {
                return true;
            }

            // Backtrack
            sides[i] -= stick;

            // Optimization: if this side was empty, no need to try further
            if (sides[i] == 0) break;
        }

        return false;
    }

    // Helper to reverse array (for descending order)
    private void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}