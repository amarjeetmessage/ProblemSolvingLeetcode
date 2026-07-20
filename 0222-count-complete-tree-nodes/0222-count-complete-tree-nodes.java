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


//  // this will take O(n) -> if we apply any traversal
// class Solution {
//     public int countNodes(TreeNode root) {
//         if(root == null) return 0;

//         int leftCount = countNodes(root.left);
//         int rightCount = countNodes(root.right);

//         return leftCount+rightCount + 1;
//     }
// }



// optimized approach
// use of formula 2^n -1 (h = height of tree) BUT there may be some node from right or not present as left level (some node are missing)

// if(leftSubtree and rightSubtree is same then it's sure that all nodes are present and formula will work properly) otherwise find recursively as above;


class Solution {

    public int findLeftHeight(TreeNode root){
        if(root == null) return 0;
        int count = 0;
        while(root != null) {
            count++;
            root = root.left;
        }
        return count;
    }
    public int findRightHeight(TreeNode root){
        if(root == null) return 0;
        int count = 0;
        while(root != null) {
            count++;
            root = root.right;
        }
        return count;
    }
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int leftHeight = findLeftHeight(root);
        int RightHeight = findRightHeight(root);

        if(leftHeight == RightHeight) {
            return ((int)Math.pow(2,leftHeight) -1);
        }

        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);

        return 1 + (leftCount + rightCount);
        
    }
}