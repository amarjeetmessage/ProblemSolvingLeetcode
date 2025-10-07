class Solution {
    public void deleteNode(ListNode node) {
        // Copy value from next node
        node.val = node.next.val;
        // Skip next node
        node.next = node.next.next;
    }
}
