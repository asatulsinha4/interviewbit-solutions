/*

Given preorder and inorder traversal of a tree, construct the binary tree.

 Note: You may assume that duplicates do not exist in the tree. 
Example :

Input :
        Preorder : [1, 2, 3]
        Inorder  : [2, 1, 3]

Return :
            1
           / \
          2   3

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
    public TreeNode buildTree(ArrayList<Integer> pre, ArrayList<Integer> in) {
        TreeNode root = null;
        if(pre.size() > 1){
            root = new TreeNode(pre.get(0));
            int k = search(in , pre.get(0));
            ArrayList<Integer> inLeft = new ArrayList<Integer>(in.subList(0,k));
            ArrayList<Integer> inRight = new ArrayList<Integer>(in.subList(k+1,in.size()));
            ArrayList<Integer> preLeft = new ArrayList<Integer>(pre.subList(1,k+1));
            ArrayList<Integer> preRight = new ArrayList<Integer>(pre.subList(k+1,pre.size()));
            root.left = buildTree(preLeft , inLeft);
            root.right = buildTree(preRight , inRight);
        }else if(pre.size()==1){
            root = new TreeNode(pre.get(0));
        }
        return root;
    }
    
    public int search(ArrayList<Integer> A , int B){
        int i=0;
        while(i<A.size()){
            if(A.get(i) == B) return i;
            i++;
        }
        return i;
    }
}
