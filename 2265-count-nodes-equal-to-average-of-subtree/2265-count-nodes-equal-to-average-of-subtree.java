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
 class Pair {
    int sum;
    int count;

    Pair(int sum, int count) {
        this.sum = sum;
        this.count = count;
    }
}
class Solution {
    int ans=0;
    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return ans;
    }
    Pair helper(TreeNode root){
        if (root == null) {
            return new Pair(0, 0);
        }

        Pair left=helper(root.left);
        Pair right=helper(root.right);
        int sum = root.val + left.sum + right.sum;
        int count = 1 + left.count + right.count;
        if(sum/count==root.val){
            ans++;
        }
        return new Pair(sum, count);
    }
}