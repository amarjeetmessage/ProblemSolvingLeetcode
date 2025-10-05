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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        // Step 1: Find the size of the linked list
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        // Step 2: If we need to remove the first node
        if (n == size) {
            return head.next;
        }

        // Step 3: Find the node just before the one to be deleted
        int indexToSearch = size - n;
        temp = head;
        for (int i = 1; i < indexToSearch; i++) {
            temp = temp.next;
        }

        // Step 4: Delete the nth node from end
        temp.next = temp.next.next;

        // Step 5: Return the head of modified list
        return head;
    }
}