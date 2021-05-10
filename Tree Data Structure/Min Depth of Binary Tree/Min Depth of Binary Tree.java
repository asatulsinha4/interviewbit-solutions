/*

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

 NOTE : The path has to end on a leaf node. 
Example :

         1
        /
       2
min depth = 2.

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
    public int min_depth = Integer.MAX_VALUE;
    public int minDepth(TreeNode A) {
        helper(A,0);
        return min_depth;
    }
    public void helper(TreeNode node,int depth){
        if(node!=null){
            depth++;
            if(node.left==null && node.right==null){
                min_depth = Math.min(min_depth,depth);
            }
            helper(node.left,depth);
            helper(node.right,depth);
        }
    }
}
