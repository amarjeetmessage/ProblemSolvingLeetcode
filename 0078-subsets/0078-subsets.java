import java.util.ArrayList;
import java.util.List;

class Solution {
    public void helper(int i, int[] nums, ArrayList<Integer> ans, List<List<Integer>> arr) {
        if (i == nums.length) {
            arr.add(new ArrayList<>(ans)); // Add a copy of the current subset
            return;
        }
        // Not taken
        helper(i + 1, nums, ans, arr);

        // Taken
        ans.add(nums[i]);
        helper(i + 1, nums, ans, arr);
        ans.remove(ans.size() - 1); // Backtrack
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> arr = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        helper(0, nums, ans, arr);
        return arr;
    }
}
