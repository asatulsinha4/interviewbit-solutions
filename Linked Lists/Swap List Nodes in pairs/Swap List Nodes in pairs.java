/*

Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

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
    public ListNode swapPairs(ListNode A) {
        ListNode curr = A;
        ListNode p = null;
        ListNode next = null;
        int c = 2;
        while(c>0&&curr!=null){
            next = curr.next;
            curr.next = p;
            p = curr;
            curr = next;
            c--;
        }
        if(next!=null) A.next = swapPairs(next);
        return p;
    }
}
