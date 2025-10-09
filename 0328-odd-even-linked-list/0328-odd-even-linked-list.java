/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        // Edge case: if list is empty or has one node
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize pointers
        ListNode odd = head;            // Start of odd list
        ListNode even = head.next;      // Start of even list
        ListNode evenHead = even;       // Store head of even list

        // Rearrange nodes
        while (even != null && even.next != null) {
            odd.next = even.next;       // Connect odd to next odd
            odd = odd.next;             // Move odd pointer forward

            even.next = odd.next;       // Connect even to next even
            even = even.next;           // Move even pointer forward
        }

        // Combine odd and even lists
        odd.next = evenHead;

        return head;
    }
}
