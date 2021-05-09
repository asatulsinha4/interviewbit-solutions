/*
Given a collection of integers that might contain duplicates, S, return all possible subsets.
Example :
If S = [1,2,2], the solution is:

[
[],
[1],
[1,2],
[1,2,2],
[2],
[2, 2]
]
*/
public class Solution {
    public HashSet<ArrayList<Integer>> h = new HashSet<>();
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A){
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
            if(!h.contains(temp)){
                ArrayList<Integer> n_temp = new ArrayList<>();
                n_temp.addAll(temp);
                h.add(n_temp);
                R.add(n_temp);
            }
            //R.add(new ArrayList<>(temp));
            generate(A,R,temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
