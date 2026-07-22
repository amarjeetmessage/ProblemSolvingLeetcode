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
    public int solve(TreeNode root){
        if(root == null) return 0;
        int left = solve(root.left);
        int right = solve(root.right);

        int max = Math.max(left, right) + 1;
        return max;

    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int m1 = solve(root.left);
        int m2 = solve(root.right);

        if(Math.abs(m1 - m2) > 1){
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }
}