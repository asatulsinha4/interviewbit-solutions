/*

Given an array A, of N integers A.

Return the highest product possible by multiplying 3 numbers from the array.

*/

public class Solution {
    public int maxp3(ArrayList<Integer> A) {
        Collections.sort(A);
        int n1 = 0;
        int n = A.size();
        if(A.get(0) < 0){
            n1 = A.get(0)*A.get(1);
        }
        int n2 = A.get(n-1);
        int n3 = A.get(n-2)*A.get(n-3);
        int max = Math.max(n1*n2 , n2*n3);
        return max;
    }
}
