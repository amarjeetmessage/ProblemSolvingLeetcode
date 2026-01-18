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
    public ListNode swapNodes(ListNode head, int k) {

        ListNode curr = head;
        int len = 0;
        while(curr != null) {
            len = len + 1;
            curr = curr.next;
        }
        ListNode n1 = head, n2 = head;
        int jump1 = k -1;
        int jumpcount1 = 0;
        while(jumpcount1 < jump1) {
            jumpcount1++;
            n1 = n1.next;
        }

        int jump2 = len - k;
        int jumpcount2 = 0;
        while(jumpcount2 < jump2) {
            jumpcount2++;
            n2 = n2.next;
        }

        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;

        return head; 
    }
}