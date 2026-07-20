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
//  */
// class Solution {
//     int diameter = 0;
//     private int longestPath(TreeNode root){
//         if(root == null) return 0;

//         int lm = longestPath(root.left);
//         int rm = longestPath(root.right);

//         diameter = Math.max(lm + rm, diameter);

//         return Math.max(lm,rm) + 1;        
//     }
//     public int diameterOfBinaryTree(TreeNode root) {
//         longestPath(root);
//         return diameter;
//     }
// }



class Solution {

    // Stores the maximum diameter found anywhere in the tree
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        // Start DFS traversal
        longestPath(root);

        // Return the maximum diameter found
        return diameter;
    }

    private int longestPath(TreeNode root) {

        // Base Case:
        // Height of an empty tree is 0
        if (root == null)
            return 0;

        // Recursively calculate height of left subtree
        int left = longestPath(root.left);

        // Recursively calculate height of right subtree
        int right = longestPath(root.right);

        // Diameter passing through current node
        // = Left Height + Right Height
        diameter = Math.max(diameter, left + right);

        // Return height of current subtree to parent
        // Height = 1 (current node) + maximum child height
        return 1 + Math.max(left, right);
    }
}