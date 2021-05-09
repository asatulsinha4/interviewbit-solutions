/*

Problem Description

Consider lines of slope -1 passing between nodes.

Given a Binary Tree A containing N nodes, return all diagonal elements in a binary tree belonging to same line.

NOTE:

See Sample Explanation for better understanding.
Order does matter in the output.
To get the same order as in the output traverse the tree same as we do in pre-order traversal.


Problem Constraints
0 <= N <= 105



Input Format
First and only Argument represents the root of binary tree A.



Output Format
Return a 1D array denoting the diagonal traversal of the tree.



Example Input
Input 1:

            1
          /   \
         4      2
        / \      \
       8   5      3
          / \    /
         9   7  6
Input 2:

             11
          /     \
         20      12
        / \       \
       1   15      13
          /  \     /
         2    17  16
          \   /
          22 34


Example Output
Output 1:

 [1, 2, 3, 4, 5, 7, 6, 8, 9]
Output 2:

 [11, 12, 13, 20, 15, 17, 16, 1, 2, 22, 34]

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
    public ArrayList<Integer> T = new ArrayList<>();
    public HashMap<Integer , ArrayList<TreeNode>> map = new HashMap<>();
    public HashSet<TreeNode> hs = new HashSet<>();
    TreeNode head = null;
    public ArrayList<Integer> solve(TreeNode A) {
        head = A;
        rightNodes(A,-1);
        traversal();
        return T;
    }
    
    public void rightNodes(TreeNode node,int l){
        if(node!=null){
            if(node==head){
                leftNodes(node,l);
            }else{
                leftNodes(node.left,l);
            }
            rightNodes(node.right,l);
        }
    }
    
    public void leftNodes(TreeNode node, int h){
        if(node!=null && !hs.contains(node)){
            h++;
            map.putIfAbsent(h, new ArrayList<TreeNode>());
            map.get(h).add(node);
            hs.add(node);
            leftNodes(node.left,h);
            rightNodes(node.right,h);
        }
    }
    
    public void traversal(){
        for(Map.Entry<Integer , ArrayList<TreeNode>> e : map.entrySet()){
            for(int i=0;i<e.getValue().size();i++){
                TreeNode temp = e.getValue().get(i);
                while(temp!=null){
                    T.add(temp.val);
                    temp = temp.right;
                }
            }
        }
    }
}
