

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
            if(sum==target && node.left==null && node.right==null) ans = 1;
            helper(node.left,sum,target);
            helper(node.right,sum,target);
        }
    }
}
