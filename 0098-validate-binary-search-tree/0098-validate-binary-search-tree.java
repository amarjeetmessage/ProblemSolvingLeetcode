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
    public boolean isValidBST(TreeNode root) {
       // solving by min max range passing as per interview prefered

       // here we will pass the min and max range for each node if they voilate return false

       //initially suppose range of root is -infinity to +infinity

       // for left move 
       //      min -> parent min 
       //      max -> parent val

       // for right move 
       //      min -> parent val 
       //      max -> parent max


       return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    public boolean validate(TreeNode root, long min, long max) {
        if(root == null) return true;

        if(root.val <= min || root.val >= max) return false;

        boolean leftSubtree = validate(root.left, min, root.val);
        boolean rightSubtree = validate(root.right, root.val, max);

        return (leftSubtree && rightSubtree);
    }
}

// Total 4 ways to solve this question (gpt)

/*
=========================================
LeetCode 98 - Constraint Note
=========================================

Constraint:
-2^31 <= Node.val <= 2^31 - 1

Node values can be:
Integer.MIN_VALUE
to
Integer.MAX_VALUE

❌ Don't do:

helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

Reason:
Input itself can be Integer.MIN_VALUE or Integer.MAX_VALUE.

Example:
Root = Integer.MIN_VALUE

Check:
root.val <= min

-2147483648 <= -2147483648  -> true ❌

A valid BST becomes invalid.

✅ Correct:

helper(root, Long.MIN_VALUE, Long.MAX_VALUE);

Reason:
long range is larger than int range, so every int value lies strictly inside the initial range.

-----------------------------------------
Rule to Remember
-----------------------------------------

If the input can reach Integer.MIN_VALUE or Integer.MAX_VALUE,
never use them as sentinel values.

Use:
Long.MIN_VALUE
Long.MAX_VALUE

=========================================
*/