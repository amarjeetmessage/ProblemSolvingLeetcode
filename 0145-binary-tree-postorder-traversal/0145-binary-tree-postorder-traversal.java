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

//  // recursive approach
// class Solution {
//     public void postorder(List<Integer> list, TreeNode root){
//         if(root == null) return ;

//         postorder(list, root.left);
//         postorder(list, root.right);
//         list.add(root.val);
//     }
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> list = new ArrayList<>();
//         postorder(list, root);
//         return list;
//     }
// }






//iterative approach (little tough)

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        while(node != null || !st.isEmpty()) {
            // move to the left
            while(node != null) {
                st.push(node);
                node = node.left;
            }

            // move the right but two condition
            if(st.peek().right != null){
                node = st.peek().right;
            }else{
                TreeNode temp = st.pop();
                list.add(temp.val);
                while(!st.isEmpty() && temp== st.peek().right){
                    temp = st.pop();
                    list.add(temp.val);
                }
            }
        }
        return list;
    }
}