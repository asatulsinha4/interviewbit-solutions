/*

Sort a linked list using insertion sort.

We have explained Insertion Sort at Slide 7 of Arrays

Insertion Sort Wiki has some details on Insertion Sort as well.

Example :

Input : 1 -> 3 -> 2

Return 1 -> 2 -> 3

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
    public ListNode insertionSortList(ListNode A) {
        ListNode head = A;
        ListNode r = A.next, l = A, prev = A;
        while(r!=null){
            if(r.val < prev.val){
                prev.next = r.next;
                if(l.val > r.val){
                    r.next = l;
                    head = r;
                }else{
                    while(l.next.val < r.val){
                        l = l.next;
                    }
                    r.next = l.next;
                    l.next = r;
                }
                l = head;
                r = prev;
            }else{
                prev = prev.next;
            }
            r = r.next;
        }
        return head;
    }
}
