/*
Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.

Make sure the combinations are sorted.

To elaborate,

Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
Entries should be sorted within themselves.
Example :
If n = 4 and k = 2, a solution is:

[
  [1,2],
  [1,3],
  [1,4],
  [2,3],
  [2,4],
  [3,4],
]
*/

public class Solution {
    public HashSet<ArrayList<Integer>> h = new HashSet<>();
    public ArrayList<ArrayList<Integer>> R = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        helper(0,A,B, new ArrayList<>());
        return R;
    }
    
    public void helper(int start, int end , int count, ArrayList<Integer> temp){
        if(count<0) return;
        if(count == 0){
            if(!h.contains(temp)){
                ArrayList<Integer> n_temp = new ArrayList<>();
                n_temp.addAll(temp);
                h.add(n_temp);
                R.add(n_temp);
            }
        }
        while(start!=end){
            start++;
            temp.add(start);
            count--;
            helper(start, end , count , temp);
            temp.remove(temp.size()-1);
            count++;
        }
    }
}
