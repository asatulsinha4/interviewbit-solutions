/*

Merge two sorted linked lists and return it as a new list.
The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.

For example, given following linked lists :

  5 -> 8 -> 20 
  4 -> 11 -> 15
The merged list should be :

4 -> 5 -> 8 -> 11 -> 15 -> 20

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
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode newHead = null;
        ListNode tempA = A;
        ListNode tempB = B;
        boolean flagR = false;
        if(A.val>B.val){
            newHead = B;
            tempB = tempB.next;
        }else{
            newHead = A;
            tempA = tempA.next;
        }
        ListNode temp = newHead;
        while(tempA!=null && tempB!=null){
            if(tempA.val > tempB.val){
                temp.next = tempB;
                temp = temp.next;
                tempB = tempB.next;
            }else{
                temp.next = tempA;
                temp = temp.next;
                tempA = tempA.next;
            }
        }
        ListNode r=null;
        if(tempA!=null && tempB==null){
            flagR = true;
            r = tempA;
        }else if(tempA==null && tempB!=null){
            flagR = true;
            r = tempB;
        }
        if(flagR){
            while(r!=null){
                temp.next = r;
                temp = temp.next;
                r = r.next;
            }
        }
        return newHead;
    }
}
