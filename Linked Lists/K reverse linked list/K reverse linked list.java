/*

Given a singly linked list and an integer K, reverses the nodes of the

list K at a time and returns modified linked list.

 NOTE : The length of the list is divisible by K 
Example :

Given linked list 1 -> 2 -> 3 -> 4 -> 5 -> 6 and K=2,

You should return 2 -> 1 -> 4 -> 3 -> 6 -> 5

Try to solve the problem using constant extra space.
  
  */

/*
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode A, int B) {
        ListNode start = A;
        ListNode previous = null;
        ListNode after = null;
        int k=B;
        while(k>0 && start!=null){
            after = start.next;
            start.next = previous;
            previous = start;
            start = after;
            k--;
        }
        if(after!=null){
            A.next = reverseList(after,B);
        }
        return previous;
    }
    public void reverseList(ListNode prev, ListNode node, ListNode after){
        ListNode curr = node;
        ListNode p = after;
        ListNode next = null;
        while(next!=after){
            next = curr.next;
            curr.next = p;
            p = curr;
            curr = next;
        }
        if(prev!=null) prev.next = p;
    }
}
