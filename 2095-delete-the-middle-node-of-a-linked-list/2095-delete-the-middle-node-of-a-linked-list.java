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
    public ListNode deleteMiddle(ListNode head) {
        // \U0001f9e9 Step 1: Edge case — if only one node, delete it
        if (head == null || head.next == null)
            return null;

        // \U0001f9ed Step 2: Initialize slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null; // will store node before middle

        // Step 3: Move slow by 1 and fast by 2
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 4: slow now points to middle → delete it
        prev.next = slow.next;

        // Step 5: Return the updated head
        return head;
    }
}
