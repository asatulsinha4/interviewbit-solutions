/*
Given are Three arrays A, B and C.

Return the sorted list of numbers that are present in atleast 2 out of the 3 arrays.
*/

public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        HashMap<Integer,Integer> a,b,c;
        a=new HashMap();
        b=new HashMap();
        c=new HashMap();
        HashSet set=new HashSet();
        for (int i: A){
            if (a.containsKey(i)){
                a.put(i,a.get(i)+1);
            }
            else a.put(i,1);
        }
        for (int i: B){
            if (b.containsKey(i)){
                b.put(i,b.get(i)+1);
            }
            else b.put(i,1);
        }
        for (int i: C){
            if (c.containsKey(i)){
                c.put(i,c.get(i)+1);
            }
            else c.put(i,1);
        }
        for (int i: a.keySet()) if (b.containsKey(i) || c.containsKey(i)) set.add(i);
        for (int i:b.keySet()) if (a.containsKey(i) || c.containsKey(i)) set.add(i);
        for (int i:c.keySet()) if (b.containsKey(i) || a.containsKey(i)) set.add(i);
        ArrayList<Integer> ans=new ArrayList<Integer>(set);
        Collections.sort(ans);
        return ans ;
    }
}
