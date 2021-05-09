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
    public ArrayList<Integer> T = new ArrayList<>();
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        inOrder(A);
        return T;
    }
    
    public void inOrder(TreeNode node){
        if(node!=null){
            inOrder(node.left);
            T.add(node.val);
            inOrder(node.right);
        }
    }
}
