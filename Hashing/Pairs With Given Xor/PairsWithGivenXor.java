/*
Problem Description

Given an 1D integer array A containing N distinct integers.

Find the number of unique pairs of integers in the array whose XOR is equal to B.

NOTE:

Pair (a, b) and (b, a) is considered to be same and should be counted once.


Problem Constraints
1 <= N <= 105

1 <= A[i], B <= 107



Input Format
First argument is an 1D integer array A.

Second argument is an integer B.



Output Format
Return a single integer denoting the number of unique pairs of integers in the array A whose XOR is equal to B.



Example Input
Input 1:

 A = [5, 4, 10, 15, 7, 6]
 B = 5
Input 2:

 A = [3, 6, 8, 10, 15, 50]
 B = 5


Example Output
Output 1:

 1
Output 2:

 2
 
 */

public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        HashSet<Integer> h = new HashSet<Integer>();
        int count = 0;
        h.add(A.get(0));
        for(int i=1;i<A.size();i++){
            int temp = A.get(i)^B;
            if(h.contains(temp)) count++;
            h.add(A.get(i));
        }
        return count;
    }
}
