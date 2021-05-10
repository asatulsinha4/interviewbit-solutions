/*

Problem Description

Given a binary tree denoted by root node A and a leaf node B from this tree.

It is known that all nodes connected to a given node (left child, right child and parent) get burned in 1 second. Then all the nodes which are connected through one intermediate get burned in 2 seconds, and so on.

You need to find the minimum time required to burn the complete binary tree.



Problem Constraints
2 <= number of nodes <= 105

1 <= node value, B <= 105

node value will be distinct



Input Format
First argument is a root node of the binary tree, A.

Second argument is an integer B denoting the node value of leaf node.



Output Format
Return an integer denoting the minimum time required to burn the complete binary tree.



Example Input
Input 1:

 Tree :      1 
            / \ 
           2   3 
          /   / \
         4   5   6
 B = 4
Input 2:

 Tree :      1
            / \
           2   3
          /     \
         4       5 
 B = 5 


Example Output
Output 1:

 4
Output 2:

 4
 
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
    public HashMap<TreeNode , ArrayList<TreeNode>> map = new HashMap<>();
    public HashSet<TreeNode> h = new HashSet<>();
    public int c = -1;
    public int solve(TreeNode A, int B) {
        int ans = 0;
        mappings(null,A);
        TreeNode node = find(A,B);
        h.add(null);
        //System.out.print(node.val+" ");
        burn(node,0);
        return c;
    }
    
    public void mappings(TreeNode pre,TreeNode node){
        if(node!=null){
            map.put(node,new ArrayList<TreeNode>());
            map.get(node).add(pre);
            map.get(node).add(node.left);
            map.get(node).add(node.right);
            mappings(node,node.left);
            mappings(node,node.right);
        }
    }
    
    public TreeNode find(TreeNode node, int B){
        TreeNode ans = null;
        TreeNode ans1 = null , ans2 = null;
        if(node!=null){
            if(node.val == B){
                ans = node;
            }else{
                ans1 = find(node.left,B);
                ans2 = find(node.right,B);
                ans = ans1==null? ans2 : ans1;
            }
        }
        return ans;
    }
    
    public void burn(TreeNode node,int count){
        if(node!=null){
            //count++;
            if(!h.contains(node)){
                h.add(node);
                boolean flag = false;
                for(int i=0;i<map.get(node).size();i++){
                    if(!h.contains(map.get(node).get(i))) flag = true;
                    //burn(map.get(node).get(i));
                }
                if(flag){
                    count++;
                    //System.out.print("node: "+node.val+" count: "+count+" ");
                }
                for(int i=0;i<map.get(node).size();i++){
                    //if(!h.contains(map.get(node).get(i))) flag = true;
                    burn(map.get(node).get(i),count);
                }
                c = Math.max(c,count);
            }
        }
    }
}
