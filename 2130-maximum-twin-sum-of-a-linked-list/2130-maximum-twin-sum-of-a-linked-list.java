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






// class Solution {
//     public int pairSum(ListNode head) {
//         List<Integer> list = new ArrayList<>();
//         while (head != null) {
//             list.add(head.val);
//             head = head.next;
//         }
//         int i = 0;
//         int j = list.size() - 1;

//         int max = Integer.MIN_VALUE;
//         while (i < j) {
//             int sum = list.get(i) + list.get(j);
//             max = Math.max(max, sum);
//             i = i + 1;
//             j = j - 1;
//         }
//         return max;
//     }
// }


class Solution {

    // 🔁 Function to reverse a linked list (standard)
    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev; // new head of reversed list
    }

    public int pairSum(ListNode head) {
        // 1️⃣ Find middle using slow & fast pointers
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2️⃣ Reverse second half using helper function
        ListNode secondHalfHead = reverseLinkedList(slow);

        // 3️⃣ Compute max twin sum
        int maxSum = 0;
        ListNode first = head;
        ListNode second = secondHalfHead;

        while (second != null) {
            maxSum = Math.max(maxSum, first.val + second.val);
            first = first.next;
            second = second.next;
        }

        return maxSum;
    }
}
