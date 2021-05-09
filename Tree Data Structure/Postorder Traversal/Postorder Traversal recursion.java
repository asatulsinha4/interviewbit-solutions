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
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        postOrder(A);
        return T;
    }
    
    public void postOrder(TreeNode node){
        if(node!=null){
            postOrder(node.left);
            postOrder(node.right);
            T.add(node.val);
        }
    }
}
