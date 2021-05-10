/*

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

Example :

    1
   / \
  2   2
 / \ / \
3  4 4  3
The above binary tree is symmetric.
But the following is not:

    1
   / \
  2   2
   \   \
   3    3
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
    public int isSymmetric(TreeNode A) {
        TreeNode left = A.left;
        TreeNode right = A.right;
        return isSymTree(left,right);
    }
    public boolean truth = true;
    public int isSymTree(TreeNode A, TreeNode B) {
        traversal(A,B);
        if(truth) return 1;
        return 0;
    }
    
    public void traversal(TreeNode A, TreeNode B){
        if(A!=null && B!=null){
            traversal(A.left , B.right);
            if(A.val!=B.val){
                truth = false;
                //System.out.print("Line 27 ");
            }
            traversal(A.right, B.left);
        }
        if((A!=null && B==null) || (A==null && B!=null)){
            truth = false;
            //System.out.print("Line 33 ");
        }
    }
}
