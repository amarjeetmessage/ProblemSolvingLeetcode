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
    public ListNode modifiedList(int[] nums, ListNode head) {
        // Step 1: Find the max value in nums to size our array correctly
        int max = 0;
        for (int num : nums) {
            if (num > max) max = num;
        }

        // Step 2: Create a boolean array to mark which values to delete
        boolean[] set = new boolean[max + 1];
        for (int num : nums) {
            set[num] = true;
        }

        // Step 3: Initialize pointers
        ListNode prev = null;
        ListNode temp = head;

        // Step 4: Traverse the list
        while (temp != null) {
            if (temp.val <= max && set[temp.val]) {
                // Node needs to be deleted
                if (prev == null) {
                    // deleting head node
                    head = head.next;
                    temp.next = null;
                    temp = head;
                } else {
                    prev.next = temp.next;
                    temp.next = null;
                    temp = prev.next;
                }
            } else {
                // move both pointers
                prev = temp;
                temp = temp.next;
            }
        }

        return head;
    }
}
