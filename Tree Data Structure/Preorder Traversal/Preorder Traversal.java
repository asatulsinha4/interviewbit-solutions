/*

Given a binary tree, return the preorder traversal of its nodes’ values.

Example :
Given binary tree

   1
    \
     2
    /
   3
return [1,2,3].

Using recursion is not allowed.

*/

**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	public ArrayList<Integer> preorderTraversal(TreeNode a) {
	    
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    
	    Stack<TreeNode> S = new Stack<TreeNode>();
	    
	   if(a == null) return res;
	   TreeNode curr = a;
	   S.push(curr);
	   
	   while(S.size() > 0){
	       curr = S.pop();
	       res.add(curr.val);
	       if(curr.right != null) S.push(curr.right);
	       if(curr.left != null) S.push(curr.left);
	   }
	    return  res;
	}
}
