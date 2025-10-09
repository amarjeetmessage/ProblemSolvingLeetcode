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
    public boolean isPalindrome(ListNode head) {
        // \U0001f9e9 Step 1: Handle edge cases
        if (head == null || head.next == null) 
            return true; // Empty or single node → palindrome

        // \U0001f9ed Step 2: Find middle of the linked list using slow-fast pointers
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;         // move slow by 1
            fast = fast.next.next;    // move fast by 2
        }
        // when loop ends → slow = middle node

        // \U0001f300 Step 3: Reverse the second half of the linked list
        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode temp = curr.next; // store next node
            curr.next = prev;          // reverse the link
            prev = curr;               // move prev forward
            curr = temp;               // move curr forward
        }
        // now prev = head of reversed second half

        // ⚖️ Step 4: Compare first half and reversed second half
        ListNode left = head;
        ListNode right = prev; // start from reversed half head
        while (right != null) { // compare until right half ends
            if (left.val != right.val) 
                return false; // mismatch found → not palindrome
            left = left.next;
            right = right.next;
        }

        // ✅ Step 5: If no mismatch, it’s a palindrome
        return true;
    }
}
