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






// // recursive method
// class Solution {
//     public void inorder(List<Integer> list, TreeNode root){
//         if(root == null) return ;

//         inorder(list, root.left);
//         list.add(root.val);
//         inorder(list, root.right);
//     }
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> list = new ArrayList<>();
//         inorder(list, root);
//         return list;
//     }
// }



// iterative approach
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> st = new Stack<>();

        TreeNode node = root;

        while(!st.isEmpty() || node != null) {
           //move to left
           while(node != null){
            st.push(node);
            node = node.left;
           }

           //print root
            node = st.pop();
            list.add(node.val);

           //move to right subtree
           node = node.right;
        }
        return list;
    }
}