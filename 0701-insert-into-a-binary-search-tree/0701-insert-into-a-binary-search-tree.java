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




 // we can solve this question by iterative aaproach and recursive approach(complicated little)
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            root = new TreeNode(val);
            return root;
        }
        // find the position and insert them 

        TreeNode temp = root; 
        while(temp != null) {
            if(val < temp.val) {
                // insertion will be int leftSubtree
                if(temp.left == null){
                    temp.left = new TreeNode(val);
                    break;
                }
                else temp = temp.left;

            }
            else {
                // insertion will be int rightSubtree
                if(temp.right == null){
                    temp.right = new TreeNode(val);
                    break;
                }
                else temp = temp.right;

            }

            
        }

        return root;
    }
}