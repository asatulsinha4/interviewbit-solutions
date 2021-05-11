/*

Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.

Notes:

Expected solution is linear in time and constant in space.
For example,

List 1-->2-->1 is a palindrome.
List 1-->2-->3 is not a palindrome.

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
    public int lPalin(ListNode A) {
        ListNode temp = A;
        ArrayList<String> a = new ArrayList<String>();
        int l=0;
        while(temp!=null){
            l++;
            a.add(String.valueOf(temp.val));
            temp = temp.next;
        }
        int n = l/2;
        int i=0;
        while(i<=n){
            if(a.get(i).intern() != a.get(a.size()-i-1).intern()){
                return 0;
            }
            i++;
        }
        return 1;
    }
}
