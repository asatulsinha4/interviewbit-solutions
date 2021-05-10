/*

Given a binary tree, flatten it to a linked list in-place.

Example :
Given


         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
Note that the left child of all nodes should be NULL.

*/

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    TreeNode head = null;
    TreeNode curr = null;
    
    public TreeNode flatten(TreeNode a) {
        preOrder(a);
        return head;
    }
    
    public void preOrder(TreeNode node){
        if(node!=null){
            TreeNode n = new TreeNode(node.val);
            if(curr==null){
                curr = n;
                head = curr;
            }else{
                curr.right = n;
                curr = curr.right;
            }
            preOrder(node.left);
            preOrder(node.right);
        }
    }
}
