/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
     /*
        LCA (Lowest Common Ancestor) - Easy Steps

        1. Apply DFS (Recursive Traversal).

        2. If you find any one of the target nodes (p or q),
        return the node itself.

        3. Search in both left and right subtrees.
        - If only one subtree returns a NON-NULL node,
            return that NON-NULL node.

        4. If both left and right subtrees return NON-NULL,
        then the current node is the Lowest Common Ancestor (LCA).
        Return the current node.

        5. If both left and right subtrees return NULL,
        then return NULL.
     */
    if(root == null || root == p || root == q) return root;
    
    TreeNode leftChild = lowestCommonAncestor(root.left,p,q);
    TreeNode rightChild = lowestCommonAncestor(root.right,p,q);

    if(leftChild == null) {
        return rightChild;
    }else if(rightChild == null) {
        return leftChild;
    }else {
        return root;
    }
    
    }
}