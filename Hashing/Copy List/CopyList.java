/*

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or NULL.

Return a deep copy of the list.

Example

Given list

   1 -> 2 -> 3
with random pointers going from

  1 -> 3
  2 -> 1
  3 -> 1
You should return a deep copy of the list. The returned answer should not contain the same node as the original list,
but a copy of them. The pointers in the returned list should not link to any node in the original input list.

*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
          return head;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode curr = head;
        while (curr != null) {
          map.put(curr, new RandomListNode(curr.label));
          curr = curr.next;
        }
        curr = head;
        while (curr != null) {
          RandomListNode copy = map.get(curr);
          if (curr.next != null) {
            copy.next = map.get(curr.next);
          }
          copy.random = map.get(curr.random);
          curr = curr.next;
        }
        return map.get(head);
    }
}
