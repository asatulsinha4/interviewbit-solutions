/*

Problem Description

Given a Linked List A consisting of N nodes.

The Linked List is binary i.e data values in the linked list nodes consist of only 0's and 1's.

You need to sort the linked list and return the new linked list.

NOTE:

Try to do it in constant space.


Problem Constraints
1 <= N <= 105

A.val = 0 or A.val = 1


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
    public ListNode solve(ListNode A) {
        ListNode temp = A;
        int l = 0;
        int z = 0;
        while(temp!=null){
            l++;
            if(temp.val == 0){
                z++;
            }
            temp = temp.next;
        }
        temp = A;
        while(temp!=null){
            if(z>0){
                temp.val = 0;
                z--;
            }else{
                temp.val = 1;
            }
            temp = temp.next;
        }
        return A;
    }
}
