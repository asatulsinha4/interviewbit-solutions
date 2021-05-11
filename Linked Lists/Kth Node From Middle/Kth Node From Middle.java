/*

Problem Description

Given a linked list A of length N and an integer B.

You need to find the value of the Bth node from the middle towards the beginning of the Linked List A.

If no such element exists, then return -1.

NOTE:

Position of middle node is: (N/2)+1, where N is the total number of nodes in the list.


Problem Constraints
1 <= N <= 105
1<= Value in Each Link List Node <= 103
1 <= B <= 105

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
    public int solve(ListNode A, int B) {
        int result = -1;
        ListNode temp = A;
        int n = 0;
        while(temp!=null){
            n++;
            temp = temp.next;
        }
        n = n/2 +1 -B;
        temp = A;
        while(temp!=null){
            n--;
            if(n==0){
                result = temp.val;
                break;
            }
            temp = temp.next;
        }
        return result;
    }
}
