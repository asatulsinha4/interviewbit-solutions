/*

Given a binary tree and a sum, find all root-to-leaf paths where each path’s sum equals the given sum.

For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return

[
   [5,4,11,2],
   [5,8,4,5]
]

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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        helper(ans,A,0,new ArrayList<>(),B);
        return ans;
    }
    
    public void helper(ArrayList<ArrayList<Integer>> ans, TreeNode node, int sum, ArrayList<Integer> tmp, int target){
        if(node!=null){
            sum = sum + node.val;
            ArrayList<Integer> temp = new ArrayList<>(tmp);
            temp.add(node.val);
            if(sum==target && node.left==null && node.right==null) ans.add(temp);
            helper(ans,node.left,sum,temp,target);
            helper(ans,node.right,sum,temp,target);
        }
    }
}
