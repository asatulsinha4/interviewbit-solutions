/*

Problem Description

Given a binary tree A with N nodes.

You have to remove all the half nodes and return the final binary tree.

NOTE:

Half nodes are nodes which have only one child.
Leaves should not be touched as they have both children as NULL.


Problem Constraints
1 <= N <= 105



Input Format
First and only argument is an pointer to the root of binary tree A.



Output Format
Return a pointer to the root of the new binary tree.



Example Input
Input 1:

           1
         /   \
        2     3
       / 
      4

Input 2:

            1
          /   \
         2     3
        / \     \
       4   5     6


Example Output
Output 1:

           1
         /   \
        4     3
Output 2:

            1
          /   \
         2     6
        / \

       4   5

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
    //TreeNode root=null;
    //TreeNode curr = null;
    public TreeNode solve(TreeNode node) {
        TreeNode root = null;
        if(node!=null){
            if(node.left==null && node.right!=null){
                root = solve(node.right);
            }else if(node.left!=null && node.right==null){
                root = solve(node.left);
            }else{
                root = new TreeNode(node.val);
                root.left = solve(node.left);
                root.right = solve(node.right);
            }
        }
        return root;
    }
}
