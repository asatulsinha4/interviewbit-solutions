/*

Given inorder and postorder traversal of a tree, construct the binary tree.

 Note: You may assume that duplicates do not exist in the tree. 
Example :

Input : 
        Inorder : [2, 1, 3]
        Postorder : [2, 3, 1]

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
    public TreeNode buildTree(int[] A, int[] B) {
        ArrayList<Integer> in = new ArrayList<Integer>();
        for(Integer i: A){
            in.add(i);
        }
        ArrayList<Integer> post = new ArrayList<Integer>();
        for(Integer i : B){
            post.add(i);
        }
        TreeNode root = build(post , in);
        return root;
    }
    
    public TreeNode build(ArrayList<Integer> post, ArrayList<Integer> in) {
        TreeNode root = null;
        if(post.size() > 1){
            root = new TreeNode(post.get(post.size()-1));
            int k = search(in , root.val);
            ArrayList<Integer> inLeft = new ArrayList<Integer>(in.subList(0,k));
            ArrayList<Integer> inRight = new ArrayList<Integer>(in.subList(k+1,in.size()));
            ArrayList<Integer> postLeft = new ArrayList<Integer>(post.subList(0,k));
            ArrayList<Integer> postRight = new ArrayList<Integer>(post.subList(k,post.size()-1));
            root.left = build(postLeft , inLeft);
            root.right = build(postRight , inRight);
        }else if(post.size()==1){
            root = new TreeNode(post.get(0));
        }
        return root;
    }
    
    public int search(ArrayList<Integer> A , int B){
        int i=0;
        while(i<A.size()){
            if(A.get(i) == B) break;
            i++;
        }
        return i;
    }
}
