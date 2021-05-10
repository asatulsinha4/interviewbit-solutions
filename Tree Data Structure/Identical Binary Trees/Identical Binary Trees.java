/*

Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Example :

Input : 

   1       1
  / \     / \
 2   3   2   3

Output : 
  1 or True
  
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
    public boolean truth = true;
    public int isSameTree(TreeNode A, TreeNode B) {
        traversal(A,B);
        if(truth) return 1;
        return 0;
    }
    
    public void traversal(TreeNode A, TreeNode B){
        if(A!=null && B!=null){
            traversal(A.left , B.left);
            if(A.val!=B.val){
                truth = false;
                //System.out.print("Line 27 ");
            }
            traversal(A.right, B.right);
        }
        if((A!=null && B==null) || (A==null && B!=null)){
            truth = false;
            //System.out.print("Line 33 ");
        }
    }
}
