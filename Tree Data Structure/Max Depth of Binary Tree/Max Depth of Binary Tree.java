/*

Given a binary tree, find its maximum depth.

The maximum depth of a binary tree is the number of nodes along the longest path from the root node down to the farthest leaf node.

 NOTE : The path has to end on a leaf node. 
Example :

         1
        /
       2
max depth = 2.

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
    public int h = 0;
    public int maxDepth(TreeNode A) {
        depth(A,0);
        return h;
    }
    
    public void depth(TreeNode node, int d){
        if(node!=null){
            d++;
            h = Math.max(d,h);
            depth(node.left,d);
            depth(node.right,d);
        }
    }
}
