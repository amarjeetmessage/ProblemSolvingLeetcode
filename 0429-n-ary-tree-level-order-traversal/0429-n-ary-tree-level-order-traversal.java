/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        
        Queue<Node> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list2 = new ArrayList<>();
            for(int i =0; i<size; i++){

                Node current = q.poll();
                list2.add(current.val);

                for(Node child : current.children){
                    q.offer(child);
                }
            }

            list.add(list2);
        }

        return list;
    }
}