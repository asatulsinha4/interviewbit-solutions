/*

Given a linked list, remove the nth node from the end of list and return its head.

For example,
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.

 Note:
If n is greater than the size of the list, remove the first node of the list.
Try doing it using constant additional space.

*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode A, int B) {
        int length = 0;
        ListNode temp = A;
        while(temp!=null){
            length++;
            temp = temp.next;
        }
        temp = A;
        ListNode prev = null;
        if(length<=B){
            ListNode head = temp.next;
            A.next = null;
            return head;
        }else{
            for(int i=0;i<length-B;i++){
                prev = temp;
                temp = temp.next;
            }
            prev.next = temp.next;
            temp.next = null;
            return A;
        }
        
    }
}
