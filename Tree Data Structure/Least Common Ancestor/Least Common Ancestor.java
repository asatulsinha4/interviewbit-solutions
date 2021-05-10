/*

Find the lowest common ancestor in an unordered binary tree given two values in the tree.

 Lowest common ancestor : the lowest common ancestor (LCA) of two nodes v and w in a tree or directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants. 
Example :


        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2_     0        8
         /   \
         7    4
For the above tree, the LCA of nodes 5 and 1 is 3.

 LCA = Lowest common ancestor 
Please note that LCA for nodes 5 and 4 is 5.

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
    int l=-1 , r=-1;
    public int lca(TreeNode A, int B, int C) {
        inOrder(A);
        int p1 = position(B);
        int p2 = position(C);
        l = Math.min(p1,p2);
        r = Math.max(p1,p2);
        //System.out.print("l: "+l+" r: "+r+" ");
        if(p1==-1 || p2==-1) return -1;
        int ans = helper(A);
        //System.out.print("ans: "+ans+" ");
        return ans;
    }
    
    public void inOrder(TreeNode node){
        if(node!=null){
            inOrder(node.left);
            T.add(node.val);
            inOrder(node.right);
        }
    }
    
    public int position(int a){
        for(int i=0;i<T.size();i++){
            if(T.get(i)==a) return i;
        }
        return -1;
    }
    
    public int helper(TreeNode node){
        int ans = -1;
        if(node!=null){
            int m = position(node.val);
            //System.out.print(node.val+" ");
            int ans1=-1, ans2=-1;
            if(m<=r && m>=l){
                ans = node.val;
                //System.out.print("line 52 node: "+ans+" ");
            }else if(m<r && m<l){
                ans1 = helper(node.right);
                //System.out.print("line 55 ans1: "+ans1+" ");
            }else if(m>r && m>l){
                ans2 = helper(node.left);
            }
            if(ans1!=-1 && ans==-1) ans = ans1;
            if(ans2!=-1 && ans==-1) ans = ans2;
            return ans;
        }
        return -1;
    }
}
