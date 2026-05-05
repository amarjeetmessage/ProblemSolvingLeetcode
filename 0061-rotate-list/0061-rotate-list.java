class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;

        // Step 1: find length
        ListNode temp = head;
        int len = 1;
        while(temp.next != null){
            temp = temp.next;
            len++;
        }

        // Step 2: make circular
        temp.next = head;

        // Step 3: effective rotations
        k = k % len;

        // Step 4: find new tail
        int steps = len - k;
        ListNode newTail = temp;

        while(steps-- > 0){
            newTail = newTail.next;
        }

        // Step 5: break
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}