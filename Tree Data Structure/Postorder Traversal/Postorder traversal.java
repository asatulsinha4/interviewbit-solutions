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
    public ArrayList<Integer> postorderTraversal(TreeNode A) 
    {
        Stack<TreeNode> s=new Stack<>();
        Stack<TreeNode> s1=new Stack<>();
        
        ArrayList<Integer> arr=new ArrayList<>();
        s.push(A);
        TreeNode temp;
        while(!s.isEmpty())
        {
            temp=s.pop();
            s1.push(temp);
            
            if(temp.left!=null)
            {
                s.push(temp.left);
            }
            if(temp.right!=null)
            {
                s.push(temp.right);
            }
            
        }
        
         while (!s1.isEmpty()) {
            TreeNode t = s1.pop();
           arr.add(t.val);
        }
        return arr;
    }
}
