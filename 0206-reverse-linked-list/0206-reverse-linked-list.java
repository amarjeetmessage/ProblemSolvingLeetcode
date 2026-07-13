// solving using the brute force appraoch using the extra space
// TC = O(n)
// SC = O(n)
class Solution {
    public ListNode reverseList(ListNode head) {
        //find length
        int len = 0;
        ListNode l = head;
        while(l != null) {
            l = l.next;
            len++;
        }

        // create arr and store all elements in them 

        ListNode arr[] = new ListNode[len];
        ListNode h = head;
        for(int i = 0; i<len; i++){
            arr[i] = h;
            h = h.next;
        }

        if(len == 0){
            return null;
        }

        // reverse array

        int start = 0;
        int last = len-1;

        while(start < last) {
            ListNode temp = arr[start];
            arr[start] = arr[last];
            arr[last] = temp;
            start++;
            last--;
        }

        // arr to LinkedList form
        for(int k = 0; k<len-1; k++){
            arr[k].next = arr[k+1];
        }
        arr[len-1].next = null;


        // return head of linkedList
        return arr[0];
    }
}






// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */

// //solved using in-place-manupulation
// //TC = O(n)
// //SC = O(1)
// class Solution {
//     public ListNode reverseList(ListNode head) {
//     // ALGORITHM USING IN PLACE MANUPULATION LL
        
//        //save next 
//        // reverse current link
//        //move all pointers farword 

//     ListNode prev = null;
//     ListNode curr = head;

//     while(curr != null) {

//         ListNode next = curr.next;//save next 

//         //reverse the curr node
//         curr.next = prev;
//         prev = curr;
//         curr = next;
        
//     }
//     return prev;//prev because dry run it at last prev will be bahave as head of new node 

//     }
// }
