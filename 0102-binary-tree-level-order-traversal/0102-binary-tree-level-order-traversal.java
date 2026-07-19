/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {

        // Final answer
        List<List<Integer>> ans = new ArrayList<>();

        // Empty tree
        if (root == null)
            return ans;

        // Queue for BFS
        Queue<TreeNode> queue = new LinkedList<>();

        // Start BFS from root
        queue.offer(root);

        // Continue until queue becomes empty
        while (!queue.isEmpty()) {

            // Number of nodes in the CURRENT LEVEL
            int size = queue.size();

            // Create a new list for this level
            List<Integer> level = new ArrayList<>();

            // Process ONLY current level nodes
            for (int i = 0; i < size; i++) {

                // Remove one node
                TreeNode current = queue.poll();

                // Store value in current level list
                level.add(current.val);

                // Children belong to NEXT LEVEL
                if (current.left != null)
                    queue.offer(current.left);

                if (current.right != null)
                    queue.offer(current.right);
            }

            // Current level completed
            // Store it inside final answer
            ans.add(level);
        }

        return ans;
    }
}