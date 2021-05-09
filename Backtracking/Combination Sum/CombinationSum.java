/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Example,
Given candidate set 2,3,6,7 and target 7,
A solution set is:

[2, 2, 3]
[7]

*/

public class Solution {
    public ArrayList<ArrayList<Integer>> R = new ArrayList<>();
    public HashSet<ArrayList<Integer>> h = new HashSet<>();
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        helper(A,new ArrayList<Integer>() , 0 , 0 , B);
        return R;
    }
    
    public void helper(ArrayList<Integer> A,ArrayList<Integer> temp, int sum, int index, int target){
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
            helper(A,temp,sum,i,target);
            temp.remove(temp.size()-1);
            sum = sum - A.get(i);
            //helper(A,temp,sum,i+1,target);
        }
    }
}
