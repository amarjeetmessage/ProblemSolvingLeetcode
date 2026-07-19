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


// we can solve this using recursion, dfs, bfs


// class Solution {
//     public int maxDepth(TreeNode root) {
//         if(root == null) return 0;

//         int leftTree = 1+maxDepth(root.left);
//         int rightTree = 1+maxDepth(root.right);

//         return Math.max(leftTree, rightTree);
//     }
// }


class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int level = 0;

        while(!q.isEmpty()){

            int size = q.size();

            while(size > 0){
                TreeNode node = q.poll();

                if(node.left != null){
                    q.offer(node.left);
                }

                if(node.right != null){
                    q.offer(node.right);
                }

                size--;
            }

            level++;
        }

        return level;
    }
}