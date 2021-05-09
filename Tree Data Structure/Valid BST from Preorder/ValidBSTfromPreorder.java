/*
You are given a preorder traversal A, of a Binary Search Tree.

Find if it is a valid preorder traversal of a BST.
*/

public class Solution {
    public int solve(ArrayList<Integer> A) {
        int []arr = A.stream().mapToInt(i->i).toArray();
        int n = A.size();
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i] < root){
                return 0;
            }
            while(!stack.isEmpty() && stack.peek() < arr[i]){
                root = stack.pop();
            }
            stack.push(arr[i]);
        }
        return 1;
    }
}
