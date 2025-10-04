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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        // Step 1: Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Step 2: Move prev pointer to node before 'left'
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Step 3: Reverse the sublist from left to right
        ListNode curr = prev.next;
        ListNode nextNode = null;

        for (int i = 0; i < right - left; i++) {
            nextNode = curr.next;
            curr.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }

        // Step 4: Return the new head
        return dummy.next;
    }
}
