/*

Given a binary search tree T, where each node contains a positive integer, and an integer K, you have to find whether or not there exist two different nodes A and B such that A.value + B.value = K.

Return 1 to denote that two such nodes exist. Return 0, otherwise.

Notes

Your solution should run in linear time and not take memory more than O(height of T).
Assume all values in BST are distinct.
Example :

Input 1: 

T :       10
         / \
        9   20

K = 19

Return: 1

Input 2: 

T:        10
         / \
        9   20

K = 40

Return: 0

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
    public ArrayList<Integer> t = new ArrayList<>();
    
    public int t2Sum(TreeNode A, int B) {
        inOrder(A);
        Collections.sort(t);
        int l=0 , r = t.size()-1;
        while(l<r){
            int sum = t.get(l) + t.get(r);
            if(sum == B) return 1;
            if(sum < B){
                l++;
            }else{
                r--;
            }
        }
        return 0;
    }
    
    public void inOrder(TreeNode root){
        if(root!=null){
            inOrder(root.left);
            t.add(root.val);
            inOrder(root.right);
        }
    }
}
