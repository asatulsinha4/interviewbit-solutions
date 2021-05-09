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
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        preOrder(A);
        return T;
    }
    
    public void preOrder(TreeNode node){
        if(node!=null){
            T.add(node.val);
            preOrder(node.left);
            preOrder(node.right);
        }
    }
}
