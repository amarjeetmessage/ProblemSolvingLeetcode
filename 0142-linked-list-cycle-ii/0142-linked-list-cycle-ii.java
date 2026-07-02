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

        // // brute force using hashset 
        // HashSet<ListNode> set = new HashSet<>();

        // while(head != null) {
        //     if(set.contains(head)){
        //         return head;
        //     }
        //     set.add(head);
        //     head = head.next;
        // }
        // return null;

        // // optimized approach using floyd's cycle detection using slow and fast approach

        if(head == null) return null;
        // if(head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) break;

        }

        if(head.next == null) return null;
        if(slow != fast ) return null;

        slow = head;

        while(fast != slow ) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;

    }
}