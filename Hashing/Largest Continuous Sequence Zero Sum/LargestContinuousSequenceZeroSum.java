/*

Find the largest continuous sequence in a array which sums to zero.

Example:


Input:  {1 ,2 ,-2 ,4 ,-4}
Output: {2 ,-2 ,4 ,-4}

*/

public class Solution {
    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        int sum = 0;
        ArrayList<Integer> output = new ArrayList<Integer>();
        int start=0;
        int end = 0;
        int maxLen = 0;
        HashMap <Integer , Integer> h = new HashMap<Integer, Integer>();
        for(int i=0;i<A.size();i++){
            sum = sum + A.get(i);
            if(sum == 0){
                maxLen = i+1;
                start = 0;
                end = i;
            }
            Integer prev_i = h.get(sum);
            if(prev_i!= null){
                if(maxLen < i-prev_i){
                    maxLen = i - prev_i;
                    start = prev_i+1;
                    end = i;
                }
            }else{
                h.put(sum,i);
            }
        }
        if( maxLen != 0){
            for(int i=start;i<=end;i++){
                output.add(A.get(i));
            }
        }
        return output;
    }
}
