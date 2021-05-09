/*
Given a binary search tree, write a function to find the kth smallest element in the tree.

Example :

Input : 
  2
 / \
1   3

and k = 2

Return : 2

As 2 is the second smallest element in the tree.
*/

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    //public HashMap<Integer , TreeNode> map = new HashMap<>();
    public ArrayList<Integer> t = new ArrayList<>();
    
    public int kthsmallest(TreeNode A, int B) {
        inOrder(A);
        Collections.sort(t);
        return t.get(B-1);
    }
    
    public void inOrder(TreeNode root){
        if(root!=null){
            inOrder(root.left);
            t.add(root.val);
            //map.put(root.val , root);
            inOrder(root.right);
        }
    }
}
