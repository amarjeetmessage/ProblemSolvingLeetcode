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
//     public TreeNode buildTree(int[] inorder, int[] postorder) {
        
//     }
// }






/**
 * LeetCode 106 - Construct Binary Tree from Inorder and Postorder Traversal
 *
 * ---------------------------------------------------------
 * APPROACH : Recursion + HashMap (Optimal)
 * ---------------------------------------------------------
 *
 * IDEA:
 *
 * 1. Postorder = Left -> Right -> Root
 *      - Last element is always the ROOT.
 *
 * 2. Inorder = Left -> Root -> Right
 *      - Root divides the tree into
 *          Left Subtree
 *          Right Subtree
 *
 * 3. Store every value and its index from inorder in a HashMap.
 *      Why?
 *      Instead of searching every time (O(n)),
 *      we can directly get the index in O(1).
 *
 * ---------------------------------------------------------
 * EXAMPLE
 * ---------------------------------------------------------
 *
 * inorder   = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 *
 * Root = 3 (Last element of Postorder)
 *
 * inorder:
 *
 *        9 | 3 | 15 20 7
 *      Left   Root   Right
 *
 * Left subtree  -> [9]
 * Right subtree -> [15,20,7]
 *
 * ---------------------------------------------------------
 * IMPORTANT DIFFERENCE FROM LC 105
 * ---------------------------------------------------------
 *
 * LC 105 (Preorder)
 * Root -> Left -> Right
 * Build Left First
 *
 * LC 106 (Postorder)
 * Left -> Right -> Root
 * Root is taken from END of array.
 *
 * Since we move backwards,
 * we must build RIGHT subtree FIRST,
 * then LEFT subtree.
 *
 * ---------------------------------------------------------
 * WHY postIndex IS GLOBAL?
 * ---------------------------------------------------------
 *
 * postorder
 *
 * 9 15 7 20 3
 *            ^
 *         postIndex
 *
 * Every recursive call consumes one root.
 *
 * postIndex--
 *
 * No need to pass recursively.
 *
 * ---------------------------------------------------------
 * WHY HASHMAP?
 * ---------------------------------------------------------
 *
 * inorder
 *
 * 9 3 15 20 7
 *
 * Store
 *
 * 9  -> 0
 * 3  -> 1
 * 15 -> 2
 * 20 -> 3
 * 7  -> 4
 *
 * Searching becomes O(1).
 *
 * ---------------------------------------------------------
 * RECURSION
 * ---------------------------------------------------------
 *
 * solve(leftBoundary,rightBoundary)
 *
 * Base Case
 *
 * if(left > right)
 *      return null;
 *
 * ---------------------------------------------------------
 * TIME
 * ---------------------------------------------------------
 *
 * Build HashMap : O(n)
 *
 * Every node visited once : O(n)
 *
 * Total : O(n)
 *
 * ---------------------------------------------------------
 * SPACE
 * ---------------------------------------------------------
 *
 * HashMap : O(n)
 *
 * Recursion Stack : O(h)
 *
 * Worst Case : O(n)
 *
 * Balanced Tree : O(log n)
 */

class Solution {

    // Starts from last element of postorder.
    int postIndex;

    // Stores
    // value -> inorder index
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        // Initially point to last element.
        postIndex = postorder.length - 1;

        // Build HashMap.
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        // Build tree.
        return solve(postorder, 0, inorder.length - 1);
    }

    /**
     * left  = left boundary in inorder
     * right = right boundary in inorder
     */
    private TreeNode solve(int[] postorder, int left, int right) {

        // ----------------------------
        // Base Case
        // ----------------------------
        if (left > right) {
            return null;
        }

        // ----------------------------
        // Step 1
        // Current postorder element is root.
        // ----------------------------
        int rootValue = postorder[postIndex--];

        TreeNode root = new TreeNode(rootValue);

        // ----------------------------
        // Step 2
        // Find root in inorder.
        // ----------------------------
        int inorderIndex = map.get(rootValue);

        // inorder
        //
        // left .... root .... right
        //
        // Left subtree
        // left -> inorderIndex-1
        //
        // Right subtree
        // inorderIndex+1 -> right

        // ****************************************************
        // IMPORTANT
        // Build RIGHT subtree FIRST.
        //
        // Because postorder is being read backwards.
        // (Root <- Right <- Left)
        // ****************************************************

        // ----------------------------
        // Step 3
        // Build Right Subtree
        // ----------------------------
        root.right = solve(postorder,
                           inorderIndex + 1,
                           right);

        // ----------------------------
        // Step 4
        // Build Left Subtree
        // ----------------------------
        root.left = solve(postorder,
                          left,
                          inorderIndex - 1);

        // ----------------------------
        // Step 5
        // Return completed subtree.
        // ----------------------------
        return root;
    }
}


