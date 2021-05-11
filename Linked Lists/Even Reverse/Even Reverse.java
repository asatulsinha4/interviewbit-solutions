/*

Problem Description

Given a linked list A , reverse the order of all nodes at even positions.



Problem Constraints
1 <= Size of linked list <= 100000



Input Format
First and only argument is the head of the Linked-List A.



Output Format
Return the head of the new linked list.



Example Input
Input 1:

A = 1 -> 2 -> 3 -> 4
Input 2:

A = 1 -> 2 -> 3


Example Output
Output 1:

 1 -> 4 -> 3 -> 2
Output 2:

 1 -> 2 -> 3

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
        ListNode odd = null;
        if(A.next==null) return A;
        ListNode c = A.next;
        ListNode even = null;
        ListNode temp = A;
        int i=0;
        while(temp!=null){
            if(i%2==0){
                if(odd==null){
                    odd = temp;
                }else{
                    odd.next = temp;
                    odd = odd.next;
                }
                if(temp.next==null) even.next = null;
            }else{
                if(even==null){
                    even = temp;
                }else{
                    even.next = temp;
                    even = even.next;
                }
                if(temp.next==null) odd.next = null;
            }
            i++;
            temp = temp.next;
        }
        //printList(c);
        //printList(A);
        even = reverseList(c);
        //printList(even);
        i=0;
        temp = A;
        odd=A.next;
        while(temp!=null){
            //System.out.print(temp.val+" ");
            if(i%2==0){
                temp.next = even;
                if(even != null) even = even.next;
            }else if(i%2==1){
                temp.next = odd;
                if(odd!=null) odd = odd.next;
            }
            i++;
            temp = temp.next;
        }
        return A;
    }
    
    public ListNode reverseList(ListNode node){
        ListNode curr = node;
        ListNode p = null;
        ListNode next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = p;
            p = curr;
            curr = next;
        }
        return p;
    }
    
    public void printList(ListNode node){
        while(node!=null){
            System.out.print(node.val+" -> ");
            node = node.next;
        }
        System.out.print("  ");
    }
}
