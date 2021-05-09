/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

The first call to next() will return the smallest number in BST. Calling next() again will return the next smallest number in the BST, and so on.

 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
Try to optimize the additional space complexity apart from the amortized time complexity. 

*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public ArrayList<Integer> t = new ArrayList<>();
    int curr = 0;

    public Solution(TreeNode root) {
        //curr = root.val;
        inOrder(root);
        Collections.sort(t);
        
    }
    
    public void inOrder(TreeNode root){
        if(root!=null){
            inOrder(root.left);
            t.add(root.val);
            inOrder(root.right);
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(curr<t.size()) return true;
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        curr++;
        return t.get(curr-1);
    }
}

/**
 * Your Solution will be called like this:
 * Solution i = new Solution(root);
 * while (i.hasNext()) System.out.print(i.next());
 */
