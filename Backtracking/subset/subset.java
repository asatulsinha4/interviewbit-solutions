/*
Given a set of distinct integers, S, return all possible subsets.

Example :

If S = [1,2,3], a solution is:

[
  [],
  [1],
  [1, 2],
  [1, 2, 3],
  [1, 3],
  [2],
  [2, 3],
  [3],
]
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A){
        ArrayList<ArrayList<Integer>> R = new ArrayList<>();
        Collections.sort(A);
        R.add(new ArrayList<Integer>());
        if(A.size() == 0) return R;
        generate(A,R, new ArrayList<Integer>(),0);
        return R;
    }
    
    public void generate(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> R, ArrayList<Integer> temp, int index){
        for(int i=index; i<A.size();i++){
            temp.add(A.get(i));
            R.add(new ArrayList<>(temp));
            generate(A,R,temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
