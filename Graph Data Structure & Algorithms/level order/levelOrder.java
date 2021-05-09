/*
Given a binary tree, return the level order traversal of its nodes’ values. (ie, from left to right, level by level).

Example :
Given binary tree

    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            ArrayList<Integer> tmp = new ArrayList<>();
            for(TreeNode node : queue){
                tmp.add(node.val);
            }
            ans.add(tmp);
            int n = queue.size();
            while(n>0){
                TreeNode temp = queue.remove();
                if(temp.left!=null) queue.add(temp.left);
                if(temp.right!=null) queue.add(temp.right);
                n--;
            }
        }
        return ans;
    }
}
