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
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        traversal(map,A,0);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(Integer h: map.keySet()){
            ans.add(map.get(h));
        }
        return ans;
    }
    
    public void traversal(HashMap<Integer,ArrayList<Integer>> map, TreeNode node, int h){
        if(node!=null){
            traversal(map,node.left,(h+1));
            map.putIfAbsent(h,new ArrayList<Integer>());
            map.get(h).add(node.val);
            traversal(map,node.right,(h+1));
        }
    }
}
