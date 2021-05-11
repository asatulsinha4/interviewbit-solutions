/*

Sort a linked list in O(n log n) time using constant space complexity.

Example :

Input : 1 -> 5 -> 4 -> 3

Returned list : 1 -> 3 -> 4 -> 5

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
    public ListNode sortList(ListNode A) {
        A = mergeSort(A);
        return A;
    }
    
    ListNode sortedMerge(ListNode a, ListNode b){
        ListNode result = null;
        if (a == null) 
            return b; 
        if (b == null) 
            return a; 
        if (a.val <= b.val) { 
            result = a; 
            result.next = sortedMerge(a.next, b); 
        } 
        else { 
            result = b; 
            result.next = sortedMerge(a, b.next); 
        } 
        return result; 
    } 
  
    ListNode mergeSort(ListNode h){
        if (h == null || h.next == null) { 
            return h; 
        } 
        ListNode middle = getMiddle(h); 
        ListNode nextofmiddle = middle.next; 
        middle.next = null; 
        ListNode left = mergeSort(h);
        ListNode right = mergeSort(nextofmiddle);
        ListNode sortedlist = sortedMerge(left, right); 
        return sortedlist; 
    } 
  
    public static ListNode getMiddle(ListNode head){
        if (head == null) 
            return head; 
  
        ListNode slow = head, fast = head; 
  
        while (fast.next != null && fast.next.next != null) { 
            slow = slow.next; 
            fast = fast.next.next; 
        } 
        return slow; 
    }
}
