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

    public boolean hasPathSum(TreeNode root, int targetSum) {

        // Case 1 : Tree is empty
        if (root == null) {
            return false;
        }

        // Case 2 : Current node is a leaf
        if (root.left == null && root.right == null) {

            // If remaining target equals node value
            if (targetSum == root.val) {
                return true;
            } else {
                return false;
            }
        }

        // Case 3 : Check left subtree
        boolean left = hasPathSum(root.left, targetSum - root.val);

        // Case 4 : Check right subtree
        boolean right = hasPathSum(root.right, targetSum - root.val);

        // Case 5 : If either side has a valid path
        if (left || right) {
            return true;
        } else {
            return false;
        }
    }
}