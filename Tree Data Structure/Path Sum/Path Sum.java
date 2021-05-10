/*

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Example :

Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem

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
    public int ans = 0;
    public int hasPathSum(TreeNode A, int B) {
        helper(A,0,B);
        return ans;
    }
    public void helper(TreeNode node,int sum, int target){
        if(node!=null && ans!=1){
            sum = sum+node.val;
            if(sum==target && node.left==null && node.right == null) ans = 1;
            helper(node.left,sum,target);
            helper(node.right,sum,target);
        }
    }
}
