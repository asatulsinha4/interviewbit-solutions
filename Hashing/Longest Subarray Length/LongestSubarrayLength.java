/*
Problem Description

Given an integer array A of size N containing 0's and 1's only.

You need to find the length of the longest subarray having count of 1’s one more than count of 0’s.



Problem Constraints
1 <= N <= 105



Input Format
First and only argument is an integer array A of size N.



Output Format
Return an integer denoting the longest length of the subarray.



Example Input
Input 1:

 A = [0, 1, 1, 0, 0, 1]
Input 2:

 A = [1, 0, 0, 1, 0]


Example Output
Output 1:

 5
Output 2:

 1

*/

public class Solution {
    public int solve(ArrayList<Integer> A) {
        int []arr = A.stream().mapToInt( i -> i).toArray();
        int n = A.size();
        for(int i=0;i<n;i++){
            if(arr[i] == 0) arr[i] = -1;
        }
        int out = 0;
        int sum = 0;
        HashMap < Integer , Integer> map = new HashMap< Integer , Integer> ();
        for(int i=0;i<n;i++){
            sum = sum + arr[i];
            if(sum == 1) out = i+1 ;
            if(!map.containsKey(sum)) map.put(sum , i);
            if(map.containsKey(sum-1)) out = Math.max(out , i - map.get(sum-1));
        }
        return out;
    }
}
