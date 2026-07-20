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
 * LeetCode 105 - Construct Binary Tree from Preorder and Inorder Traversal
 *
 * ---------------------------------------------------------
 * APPROACH : Recursion + HashMap (Optimal)
 * ---------------------------------------------------------
 *
 * IDEA:
 *
 * 1. Preorder = Root -> Left -> Right
 *      - First element is always the ROOT.
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
 * preorder = [3,9,20,15,7]
 * inorder  = [9,3,15,20,7]
 *
 * Root = 3
 *
 * inorder:
 *
 *        9 | 3 | 15 20 7
 *      Left   Root   Right
 *
 * Left subtree  -> [9]
 * Right subtree -> [15,20,7]
 *
 * Continue recursively.
 *
 * ---------------------------------------------------------
 * WHY preIndex IS GLOBAL?
 * ---------------------------------------------------------
 *
 * Every recursive call needs the next preorder element.
 *
 * preorder:
 * 3 9 20 15 7
 * ^
 *
 * After creating root,
 * move to next element.
 *
 * preIndex++
 *
 * No need to pass it recursively.
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
 * Now finding any node position takes O(1).
 *
 * ---------------------------------------------------------
 * RECURSION
 * ---------------------------------------------------------
 *
 * solve(leftBoundary,rightBoundary)
 *
 * leftBoundary  -> left limit inside inorder
 * rightBoundary -> right limit inside inorder
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
 * Building HashMap : O(n)
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

    // Points to current root in preorder array.
    int preIndex = 0;

    // Stores
    // value -> inorder index
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Build HashMap
        // So that searching root in inorder becomes O(1).
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        // Build entire tree.
        return solve(preorder, 0, inorder.length - 1);
    }

    /**
     * left  = left boundary in inorder
     * right = right boundary in inorder
     */
    private TreeNode solve(int[] preorder, int left, int right) {

        // ----------------------------
        // Base Case
        // ----------------------------
        // No node exists in this range.
        if (left > right) {
            return null;
        }

        // ----------------------------
        // Step 1
        // Current preorder element is root.
        // ----------------------------
        int rootValue = preorder[preIndex++];

        TreeNode root = new TreeNode(rootValue);

        // ----------------------------
        // Step 2
        // Find root position in inorder.
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

        // ----------------------------
        // Step 3
        // Build Left Subtree
        // ----------------------------
        root.left = solve(preorder,
                          left,
                          inorderIndex - 1);

        // ----------------------------
        // Step 4
        // Build Right Subtree
        // ----------------------------
        root.right = solve(preorder,
                           inorderIndex + 1,
                           right);

        // ----------------------------
        // Step 5
        // Return completed subtree.
        // ----------------------------
        return root;
    }
}