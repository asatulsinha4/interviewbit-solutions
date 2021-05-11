/*

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Try solving it using constant additional space.

Example :

Input : 

                  ______
                 |     |
                 \/    |
        1 -> 2 -> 3 -> 4

Return the node corresponding to node 3. 

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
    public ListNode detectCycle(ListNode a) {
        HashSet<ListNode> h = new HashSet<ListNode>();
        ListNode temp = a;
        while(temp!=null){
            if(h.contains(temp)){
                return temp;
            }
            h.add(temp);
            temp = temp.next;
        }
        return null;
    }
}
