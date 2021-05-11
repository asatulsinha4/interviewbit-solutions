/*

Given a linked list A of length N and an integer B.

You need to reverse every alternate B nodes in the linked list A.



Problem Constraints
1 <= N <= 105
1<= Value in Each Link List Node <= 103
1 <= B <= N
N is divisible by B

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
    public ListNode solve(ListNode A, int B) {
        A = helper(A,B,0);
        return A;
    }
    
    public ListNode helper(ListNode node, int B, int k){
        if(node == null) return node;
        ListNode temp = node, end = null;
        int n = B;
        while(n>0 && temp!=null){
            end = temp;
            temp = temp.next;
            n--;
        }
        if(k==0){
            ListNode prev=null, curr = node, next = null;
            end.next = null;
            while(curr!=null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                n--;
            }
            node.next = helper(temp,B,1);
            node = prev;
        }else{
            end.next = helper(temp,B,0);
        }
        return node;
    }
}
