/*

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.

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
    public ListNode partition(ListNode A, int B) {
        ListNode temp1 = A;
        ListNode temp2 = A;
        ListNode prev = null;
        ListNode after = null;
        ListNode head = A;
        ListNode p = null;
        boolean found = false;
        while(temp2!=null){
            if(temp1.val<B){
                temp2 = temp1;
                temp1 = temp1.next;
            }
            if(temp1 == null){
                return A;
            }
            if(temp1.val >= B && !found){
                after = temp1;
                p = (temp1 == A) ? null : temp2;
                prev = temp2;
                temp2 = temp2.next;
                if(temp2 == null){
                    return A;
                }
                found = true;
            }
            if(found){
                //later = temp2.next;
                //System.out.print("Line 34 val = "+temp2.val+" ");
                if(temp2!=null && temp2.val < B){
                    if(p!=null){
                        p.next = temp2;
                    }
                    prev.next = temp2.next;
                    temp2.next = after;
                    if(p == null){
                        head = temp2;
                    }
                    //System.out.print("Line 38 val = "+temp2.val+" ");
                    p = temp2;
                    temp2 = prev;
                    //printList(A);
                }
                prev = temp2;
                temp2 = temp2.next;
                //System.out.print("Line 43 ");
            }
        }
        return head;
    }
    
    
    public static void printList(ListNode A){
        while(A!=null){
            System.out.print(A.val+" -> ");
            A = A.next;
        }
        System.out.print(" ");
    }
}
