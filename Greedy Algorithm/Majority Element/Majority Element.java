/*

Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example :

Input : [2, 1, 2]
Return  : 2 which occurs 2 times which is greater than 3/2. 

*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int majorityElement(final List<Integer> A) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = A.size();
        for(int i=0;i<n;i++){
            if(map.containsKey(A.get(i))){
                map.put(A.get(i) , map.get(A.get(i))+1);
            }else{
                map.put(A.get(i),1);
            }
        }
        for(Integer i : map.keySet()){
            if(map.get(i)>n/2) return i;
        }
        return 0;
    }
}
