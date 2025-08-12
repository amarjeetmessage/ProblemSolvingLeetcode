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
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE); // Use long to avoid int overflow
    }

    private boolean isValid(TreeNode node, long min, long max) {
        if (node == null) return true; // Empty tree is valid

        if (node.val <= min || node.val >= max) return false; // Check BST property

        // Left subtree: max value becomes current node's value
        // Right subtree: min value becomes current node's value
        return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
    }
}
