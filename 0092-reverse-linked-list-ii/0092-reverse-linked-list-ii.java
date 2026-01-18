class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // nodes reverse = right - left + 1
        // dummy node ??? Yes
        //
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 0 -> 1 -> 2 -> 3 -> 4 -> 5
        //    h
        //    p
        //         c
        // left = 2
        // right = 4
        int counter = 0;
        ListNode p = dummy,
             c = head;

        while (counter < left - 1) {
            p = c;
            c = c.next;
            counter = counter + 1;
        }

        // 0 -> 1 -> 2 -> 3 -> 4 -> 5
        //    h
        //    p
        //         c
        //         c
        // left = 2
        // right = 4
        ListNode prev = null,
             curr = c;

        counter = 0;
        // 7 8 6 5 4 3 2 0 9 1
        //       |
        // T:O(n) S: O(1)
        while (counter < (right - left + 1)) {
            counter = counter + 1;

            // save next
            ListNode next = curr.next;

            // reverse the curr node
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // 0 -> 1 -> 2 -> 3 -> 4 -> 5
        //    h
        //    p
        //         c
        //         c
        // 0 -> 1 -> 4 -> 3 -> 2 -> 5
        // d
        //    p
        //         4 -> 3 -> 2    5
        //                        c
        // left = 2
        // right = 4
        p.next = prev;
        c.next = curr;

        return dummy.next;

    }
}