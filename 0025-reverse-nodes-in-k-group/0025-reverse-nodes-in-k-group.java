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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // Dummy node to simplify connections
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroup = dummy;

        while (true) {
            // Find the kth node from prevGroup
            ListNode kth = getKthNode(prevGroup, k);
            if (kth == null) break; // Less than k nodes remain

            ListNode nextGroup = kth.next;

            // Reverse k nodes
            ListNode prev = nextGroup;
            ListNode curr = prevGroup.next;

            while (curr != nextGroup) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // Connect reversed part to previous section
            ListNode temp = prevGroup.next;
            prevGroup.next = kth;
            prevGroup = temp;
        }

        return dummy.next;
    }

    // Helper to get kth node from a starting point
    private ListNode getKthNode(ListNode start, int k) {
        while (start != null && k > 0) {
            start = start.next;
            k--;
        }
        return start;
    }
}
