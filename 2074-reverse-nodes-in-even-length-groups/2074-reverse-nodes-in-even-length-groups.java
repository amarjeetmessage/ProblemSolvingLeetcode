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
    public ListNode reverseEvenLengthGroups(ListNode head) {

        // Step 1: Calculate total length of linked list
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }

        curr = head; // reset pointer
        ListNode prevGroupTail = null; // tail of previous group
        int groupSize = 1;

        // Step 2: Traverse group by group
        while (curr != null) {

            // Actual size of group (important for last group)
            int actualSize = Math.min(groupSize, len);

            // Case 1: Even length group → reverse
            if (actualSize % 2 == 0) {

                ListNode prev = null;
                ListNode groupHead = curr; // will become tail after reverse

                int count = 0;

                // Reverse 'actualSize' nodes
                while (count < actualSize) {
                    ListNode next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                    count++;
                }

                // Connect previous group with current reversed group
                if (prevGroupTail != null) {
                    prevGroupTail.next = prev;
                } else {
                    // First group case
                    head = prev;
                }

                // Connect tail of reversed group to next part
                groupHead.next = curr;

                // Update prevGroupTail
                prevGroupTail = groupHead;

            } 
            // Case 2: Odd length group → no reverse
            else {
                int count = 0;
                ListNode groupHead = curr;

                // Move forward without reversing
                while (count < actualSize) {
                    prevGroupTail = curr;
                    curr = curr.next;
                    count++;
                }
            }

            // Update for next group
            len -= actualSize;
            groupSize++;
        }

        return head;
    }
}

//if you solve this ques mostly all concept revised mark it for interview 