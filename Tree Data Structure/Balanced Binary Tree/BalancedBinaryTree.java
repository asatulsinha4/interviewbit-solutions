/*

Given a binary tree, determine if it is height-balanced.

 Height-balanced binary tree : is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Example :

Input : 
          1
         / \
        2   3

Return : True or 1 

Input 2 : 
         3
        /
       2
      /
     1

Return : False or 0 
         Because for the root node, left subtree has depth 2 and right subtree has depth 0. 
         Difference = 2 > 1.

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
    boolean flag = true;
    public int isBalanced(TreeNode A) {
        function(A);
        if(!flag) return 0;
        return 1;
    }
    
    public void function(TreeNode node){
        if(node!=null && flag){
            Depth left = new Depth();
            Depth right = new Depth();
            int l = left.findDepth(node.left);
            int r = right.findDepth(node.right);
            if(Math.abs(l-r) > 1){
                flag = false;
            }
            if(flag){
                function(node.left);
                function(node.right);
            }
        }
    }
}

class Depth {
    int maxDepth = 0;
    public int findDepth(TreeNode node){
        function(node,0);
        return maxDepth;
    }
    
    public void function(TreeNode node,int d){
        if(node!=null){
            d++;
            maxDepth = Math.max(maxDepth , d);
            function(node.left,d);
            function(node.right,d);
        }
    }
}
