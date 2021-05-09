/*

Two elements of a binary search tree (BST) are swapped by mistake.
Tell us the 2 values swapping which the tree will be restored.

 Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution? 
Example :


Input : 
         1
        / \
       2   3

Output : 
       [1, 2]

Explanation : Swapping 1 and 2 will change the BST to be 
         2
        / \
       1   3
which is a valid BST

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
    public ArrayList<Integer> recoverTree(TreeNode A) {
        inOrder(A);
        ArrayList<Integer> ans = new ArrayList<>();
        int []arr = t.stream().mapToInt(i -> i).toArray();
        Collections.sort(t);
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=t.get(i)){
                ans.add(Math.min(arr[i],t.get(i)));
                ans.add(Math.max(arr[i],t.get(i)));
                break;
            }
        }
        return ans;
    }
    
    public void inOrder(TreeNode root){
        if(root!=null){
            inOrder(root.left);
            t.add(root.val);
            inOrder(root.right);
        }
    }
}

