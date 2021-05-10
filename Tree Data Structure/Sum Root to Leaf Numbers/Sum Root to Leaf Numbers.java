/*

Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers % 1003.

Example :

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = (12 + 13) % 1003 = 25 % 1003 = 25.

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
    public ArrayList<Double> num = new ArrayList<>();
    public int sumNumbers(TreeNode A) {
        generate(A,0);
        double sum = 0;
        for(Double i : num){
            sum = sum + i%1003;
            sum = sum%1003;
        }
        return (int)sum;
    }
    
    public void generate(TreeNode node , double n){
        if(node!=null){
            n = 10*n + node.val;
            n = n%1003;
            boolean flag = false;
            if(node.left == null && node.right == null) flag = true;
            if(flag){
                num.add(n);
            }else{
                generate(node.left , n);
                generate(node.right , n);
            }
        }
    }
}
