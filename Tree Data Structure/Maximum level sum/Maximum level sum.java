/*

Problem Description

Given a Binary Tree denoted by root node A having integer value on nodes. You need to find maximum sum level in it.



Problem Constraints
1 <= number of nodes <= 105

1 <= value on nodes <= 105



Input Format
First and only argument is a root node of Binary Tree A.



Output Format
Return an integer denoting the maximum sum level in the tree.



Example Input
Input 1:

 Tree:      4
          /   \
         2     5
        / \   / \
       1  3  2   6
Input 2:

 Tree:      1
          /   \
         2     3
       /  \     \
      4    5     8
                / \
               6   7  


Example Output
Output 1:

 12
Output 2:

 17

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
    public HashMap<Integer, Integer> map = new HashMap<>();
    public int solve(TreeNode A) {
        sum(A,0);
        int max = 0;
        for(Integer i : map.values()){
            max = Math.max(i,max);
        }
        return max;
    }
    
    public void sum(TreeNode node, int level){
        if(node!=null){
            if(map.containsKey(level)){
                map.put(level,map.get(level)+node.val);
            }else{
                map.put(level,node.val);
            }
            sum(node.left,level+1);
            sum(node.right,level+1);
        }
    }
}
