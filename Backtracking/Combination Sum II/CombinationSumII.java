/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.
Example :

Given candidate set 10,1,2,7,6,1,5 and target 8,

A solution set is:

[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6]
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> R = new ArrayList<>();
    public HashSet<ArrayList<Integer>> h = new HashSet<>();
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        Collections.sort(a);
        helper(a,new ArrayList<>(), 0 , 0 , b);
        return R;
    }
    
    public void helper(ArrayList<Integer> A, ArrayList<Integer> temp, int sum, int index, int target){
        if(sum>target) return;
        if(sum == target){
            if(!h.contains(temp)){
                ArrayList<Integer> n_temp = new ArrayList<>();
                n_temp.addAll(temp);
                h.add(n_temp);
                R.add(n_temp);
            }
        }
        for(int i=index;i<A.size();i++){
            temp.add(A.get(i));
            sum += A.get(i);
            helper(A,temp,sum,i+1,target);
            temp.remove(temp.size()-1);
            sum = sum - A.get(i);
        }
    }
}
