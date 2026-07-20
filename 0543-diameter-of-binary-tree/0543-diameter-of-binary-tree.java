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
    int diameter = 0;
    private int longestPath(TreeNode root){
        if(root == null) return 0;

        int lm = longestPath(root.left);
        int rm = longestPath(root.right);

        diameter = Math.max(lm + rm, diameter);

        return Math.max(lm,rm) + 1;        
    }
    public int diameterOfBinaryTree(TreeNode root) {
        longestPath(root);
        return diameter;
    }
}