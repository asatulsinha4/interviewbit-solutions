/*

You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

    342 + 465 = 807
Make sure there are no trailing zeros in the output list
So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.

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
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode temp_A = A;
        ListNode temp_B = B;
        int carry = 0;
        ListNode C = new ListNode(0);
        ListNode prev = null;
        ListNode newNode = C;
        while(temp_A!=null || temp_B!=null){
            if(temp_A==null && temp_B!=null){
                ListNode temp_a = new ListNode(0);
                temp_a.next = null;
                temp_A=temp_a;
            }else if(temp_A!=null && temp_B==null){
                ListNode temp_b = new ListNode(0);
                temp_b.next = null;
                temp_B=temp_b;
            }
            
            if(newNode.next == null){
                ListNode newC = new ListNode(0);
                newC.next = null;
                newNode.next = newC;
            }
            int temp = temp_A.val + temp_B.val + carry;
            carry = temp/10;
            temp = temp%10;
            newNode.val = temp;
            prev = newNode;
            newNode = newNode.next;
            temp_A = temp_A.next;
            temp_B = temp_B.next;
        }
        if(carry>0){
            newNode.val = carry;
        }else{
            prev.next = null;
        }
        return C;
    }
}
