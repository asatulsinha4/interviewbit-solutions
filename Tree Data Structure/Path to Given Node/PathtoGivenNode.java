/*

Problem Description

Given a Binary Tree A containing N nodes.

You need to find the path from Root to a given node B.

NOTE:

No two nodes in the tree have same data values.
You can assume that B is present in the tree A and a path always exists.


Problem Constraints
1 <= N <= 105

1 <= Data Values of Each Node <= N

1 <= B <= N



Input Format
First Argument represents pointer to the root of binary tree A.

Second Argument is an integer B denoting the node number.



Output Format
Return an one-dimensional array denoting the path from Root to the node B in order.



Example Input
Input 1:

 A =

           1
         /   \
        2     3
       / \   / \
      4   5 6   7 


B = 5

Input 2:

 A = 
            1
          /   \
         2     3
        / \ .   \
       4   5 .   6


B = 1




Example Output
Output 1:

 [1, 2, 5]
Output 2:

 [1]
 
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
    public ArrayList<Integer> path = new ArrayList<>();
    public int[] solve(TreeNode A, int B) {
        find(A,B,new ArrayList<>(),false);
        int []arr = path.stream().mapToInt(i->i).toArray();
        return arr;
    }
    public void find(TreeNode node , int a , ArrayList<Integer> A, boolean b){
        if(node!=null && !b){
            ArrayList<Integer> B = new ArrayList<>();
            B.addAll(A);
            B.add(node.val);
            if(node.val == a) b = true;
            if(b) path.addAll(B);
            find(node.left , a , B , b);
            find(node.right , a , B , b);
        }
    }
}
