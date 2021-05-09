/*

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

 Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
Example :


Given A : [1, 2, 3]
A height balanced BST  : 

      2
    /   \
   1     3

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
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public TreeNode sortedArrayToBST(final int[] A) {
        TreeNode root = constructTree(A , 0 , A.length-1);
        return root;
    }
    
    public TreeNode constructTree(final int[]arr , int start , int end){
        TreeNode root = null;
        if(start <= end){
            int n = start + (end - start)/2;
            root = new TreeNode(arr[n]);
            root.left = constructTree(arr , start , n-1);
            root.right = constructTree(arr , n+1 , end);
        }
        return root;
    }
}
