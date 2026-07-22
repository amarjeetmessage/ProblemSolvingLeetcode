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

    public TreeNode deleteNode(TreeNode root, int key) {

        // Base Case
        if (root == null) return null;

        // Search in Left Subtree
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }

        // Search in Right Subtree
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }

        // Node Found
        else {

            // CASE 1: Leaf Node
            if (root.left == null && root.right == null) {
                return null;
            }

            // CASE 2: Only Right Child
            if (root.left == null) {
                return root.right;
            }

            // CASE 3: Only Left Child
            if (root.right == null) {
                return root.left;
            }

            // CASE 4: Two Children

            // Find Inorder Successor (Minimum in Right Subtree)
            TreeNode successor = findMin(root.right);

            // Replace current node value with successor value
            root.val = successor.val;

            // Delete duplicate successor node
            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }

    // Find Minimum Node in BST
    public TreeNode findMin(TreeNode root) {

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }
}

// Read note of this question 