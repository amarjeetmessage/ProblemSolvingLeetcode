// solving using the brute force appraoch using the extra space
//TC = O(n)
//SC = O(n)
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         //for 1 or 0 number of nodes
//         if(head == null || head.next == null) {
//             return head;
//         }

//         // 1 -> 2 -> 3 -> 4
//         // store in list as [ 4, 3, 2, 1 ]
//         // 4 -> 3 -> 2 -> 1 -> null

//         int len = 0;
//         ListNode l = head;
//         while(l != null) {
//             l = l.next;
//             len++;
//         }
//         //finded length of LL = 4

//         // store in list 
//         ListNode[] arr = new ListNode[len];
//         //[null , null , null , null]


//         //fill in array normally
//         l = head;
//         int i = 0;
//         while(l != null) {
//             arr[i] = l;
//             i++;
//             l = l.next;
//         }
//         //it stores nodes null value
//         //[(1) , (2) , (3), (4)]

//         //now reverse the list 
//         int start = 0;
//         int end = len -1 ;

//         while(start < end) {
//             ListNode temp = arr[start];
//             arr[start] = arr[end];
//             arr[end] = temp;

//             start = start + 1;
//             end = end -1 ;
//         }
//         //not look like as [(4), (3), (2), (1)];

//         //not acc to list point
//         for(int k = 0; k<len-1; k++) {//note that (len -1 )
//             arr[k].next = arr[k+1];
//         }
//         arr[len - 1].next = null;//last node points to null

//         return arr[0]; 
//     }
// }






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

//solved using in-place-manupulation
//TC = O(n)
//SC = O(1)
class Solution {
    public ListNode reverseList(ListNode head) {
    // ALGORITHM USING IN PLACE MANUPULATION LL
        
       //save next 
       // reverse current link
       //move all pointers farword 

    ListNode prev = null;
    ListNode curr = head;

    while(curr != null) {

        ListNode next = curr.next;//save next 

        //reverse the curr node
        curr.next = prev;
        prev = curr;
        curr = next;
        
    }
    return prev;//prev because dry run it at last prev will be bahave as head of new node 

    }
}
