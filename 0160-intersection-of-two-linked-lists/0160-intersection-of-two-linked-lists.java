/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // --------------------------------------------------------------------
        // ❌ Approach 1: Brute Force (O(m × n), O(1))
        // --------------------------------------------------------------------
        /*
        ListNode a = headA;
        while (a != null) {
            ListNode b = headB;
            while (b != null) {
                if (a == b) {  // same reference → intersection
                    return a;
                }
                b = b.next;
            }
            a = a.next;
        }
        return null;
        */

        // --------------------------------------------------------------------
        // ✅ Approach 2: Using HashSet (O(m + n), O(m))
        // --------------------------------------------------------------------
        /*
        java.util.HashSet<ListNode> set = new java.util.HashSet<>();
        ListNode a = headA;
        while (a != null) {
            set.add(a);
            a = a.next;
        }
        ListNode b = headB;
        while (b != null) {
            if (set.contains(b)) {
                return b; // Intersection found
            }
            b = b.next;
        }
        return null;
        */

        // --------------------------------------------------------------------
        // ✅ Approach 3: Using Length Difference (O(m + n), O(1))
        // --------------------------------------------------------------------
        /*
        int lenA = 0, lenB = 0;
        ListNode a = headA, b = headB;

        // Find lengths of both lists
        while (a != null) {
            lenA++;
            a = a.next;
        }
        while (b != null) {
            lenB++;
            b = b.next;
        }

        // Reset pointers
        a = headA;
        b = headB;

        // Advance pointer of longer list
        int diff = Math.abs(lenA - lenB);
        if (lenA > lenB) {
            for (int i = 0; i < diff; i++) {
                a = a.next;
            }
        } else {
            for (int i = 0; i < diff; i++) {
                b = b.next;
            }
        }

        // Move both together until they meet
        while (a != b) {
            a = a.next;
            b = b.next;
        }

        return a; // Intersection node or null
        */

        // --------------------------------------------------------------------
        // ✅✅ Approach 4: Two Pointer Method (Best, O(m + n), O(1))
        // Without using ternary shortcut
        // --------------------------------------------------------------------

        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        // Traverse both lists
        while (a != b) {

            // If 'a' reaches end, redirect to headB
            if (a == null) {
                a = headB;
            } else {
                a = a.next;
            }

            // If 'b' reaches end, redirect to headA
            if (b == null) {
                b = headA;
            } else {
                b = b.next;
            }
        }

        // Either both null (no intersection) or same intersection node
        return a;
    }
}
