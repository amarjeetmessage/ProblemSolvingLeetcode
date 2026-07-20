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
// class Solution {
//     public boolean isCousins(TreeNode root, int x, int y) {
        
//     }
// }



import java.util.*;

class Solution {

    // ==========================================================
    // APPROACH 1 : DFS (Recursion) - O(n)
    // ==========================================================

    /*
    IDEA

    Cousins means:
    1. Same Depth
    2. Different Parent

    During DFS store:

    parent of x
    parent of y

    depth of x
    depth of y

    Finally check

    depthX == depthY
            &&
    parentX != parentY
    */

    // Parent of x
    TreeNode parentX = null;

    // Parent of y
    TreeNode parentY = null;

    // Depth of x
    int depthX = 0;

    // Depth of y
    int depthY = 0;

    public boolean isCousins(TreeNode root, int x, int y) {

        // Start DFS from root
        dfs(root, null, 0, x, y);

        // Cousins =>
        // Same depth
        // Different parent
        return depthX == depthY && parentX != parentY;
    }

    /*
        root   -> current node

        parent -> parent of current node

        depth  -> current node level
    */

    private void dfs(TreeNode root, TreeNode parent, int depth, int x, int y) {

        // Base Case
        if (root == null)
            return;

        // Found x
        if (root.val == x) {

            parentX = parent;

            depthX = depth;
        }

        // Found y
        if (root.val == y) {

            parentY = parent;

            depthY = depth;
        }

        // Search Left
        dfs(root.left, root, depth + 1, x, y);

        // Search Right
        dfs(root.right, root, depth + 1, x, y);
    }
}

/*


==========================================================
APPROACH 2 : BFS (Level Order) - O(n)
==========================================================


class Solution {

    public boolean isCousins(TreeNode root, int x, int y) {

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {

            int size = q.size();

            boolean foundX = false;
            boolean foundY = false;

            for (int i = 0; i < size; i++) {

                TreeNode node = q.poll();

                if (node.val == x)
                    foundX = true;

                if (node.val == y)
                    foundY = true;

                if (node.left != null && node.right != null) {

                    if ((node.left.val == x && node.right.val == y) ||
                        (node.left.val == y && node.right.val == x))
                        return false;
                }

                if (node.left != null)
                    q.offer(node.left);

                if (node.right != null)
                    q.offer(node.right);
            }

            if (foundX && foundY)
                return true;

            if (foundX || foundY)
                return false;
        }

        return false;
    }
}

*/