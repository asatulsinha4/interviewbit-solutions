/*
Given an array A of integers, find the index of values that satisfy A + B = C + D, where A,B,C & D are integers values in the array

Note:

1) Return the indices `A1 B1 C1 D1`, so that 
  A[A1] + A[B1] = A[C1] + A[D1]
  A1 < B1, C1 < D1
  A1 < C1, B1 != D1, B1 != C1 

2) If there are more than one solutions, 
   then return the tuple of values which are lexicographical smallest. 

Assume we have two solutions
S1 : A1 B1 C1 D1 ( these are values of indices int the array )  
S2 : A2 B2 C2 D2

S1 is lexicographically smaller than S2 iff
  A1 < A2 OR
  A1 = A2 AND B1 < B2 OR
  A1 = A2 AND B1 = B2 AND C1 < C2 OR 
  A1 = A2 AND B1 = B2 AND C1 = C2 AND D1 < D2
Example:

Input: [3, 4, 7, 1, 2, 9, 8]
Output: [0, 2, 3, 5] (O index)
If no solution is possible, return an empty list.

*/

public class Solution {
    public ArrayList<Integer> equal(ArrayList<Integer> A) {
        Map<Integer, int[]> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
          for (int j = i + 1; j < A.size(); j++) {
            int sum = A.get(i) + A.get(j);
            if (map.containsKey(sum)) {
              int[] match = map.get(sum);
              int a = match[0];
              int b = match[1];
              int c = i;
              int d = j;
              if (a < b && c < d && a < c && b != d && b != c) {
                ans.add(new ArrayList<>(Arrays.asList(a, b, c, d)));
              }
            }
            map.putIfAbsent(sum, new int[]{i, j});
          }
        }
        ans.sort(
            Comparator.comparingInt((ArrayList<Integer> o) -> o.get(0)).thenComparingInt(o -> o.get(1))
                .thenComparingInt(o -> o.get(2)).thenComparingInt(o -> o.get(3)));
        return ans.size() == 0 ? new ArrayList<>() : ans.get(0);
    }
}
