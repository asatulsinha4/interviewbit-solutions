/*

Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

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
    public ListNode deleteDuplicates(ListNode A) {
        ListNode fix = A;
        ListNode fast = A;
        while(fast!=null){
            if(fix.val != fast.val){
                if(fix != fast){
                    fix.next = fast;
                }
                fix = fast;
            }else{
                if (fast.next == null){
                    fix.next = null;
                }
            }
            fast = fast.next;
        }
        return A;
    }
}
