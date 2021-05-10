/*

Given a binary tree, return the zigzag level order traversal of its nodes’ values. (ie, from left to right, then right to left for the next level and alternate between).

Example :
Given binary tree

    3
   / \
  9  20
    /  \
   15   7
return

[
         [3],
         [20, 9],
         [15, 7]
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
    public HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
    //public ArrayList<Integer> T = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        traversal(A,0);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(Integer i: map.keySet()){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(map.get(i));
            if(i%2==1) Collections.reverse(temp);
            ans.add(temp);
        }
        return ans;
    }
    
    public void traversal(TreeNode node, int level){
        if(node!=null){
            map.putIfAbsent(level,new ArrayList<Integer>());
            map.get(level).add(node.val);
            traversal(node.left,level+1);
            traversal(node.right,level+1);
        }
    }
}
