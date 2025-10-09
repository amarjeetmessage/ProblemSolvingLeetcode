/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect if a cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {  // Cycle detected
                // Step 2: Move one pointer to head
                slow = head;

                // Step 3: Move both one step at a time
                // They will meet at the start of the cycle
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // or fast, both are at start of cycle
            }
        }

        // No cycle found
        return null;
    }
}
