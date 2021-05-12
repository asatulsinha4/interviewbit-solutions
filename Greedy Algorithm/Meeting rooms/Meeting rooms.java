/*

Given an 2D integer array A of size N x 2 denoting time intervals of different meetings.

Where:

A[i][0] = start time of the ith meeting.
A[i][1] = end time of the ith meeting.
Find the minimum number of conference rooms required so that all meetings can be done.

*/

public class Solution {
    public int solve(int[][] A) {
        int row = A.length;
        int max = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> dep = new ArrayList<>();
        for(int i=0;i<row;i++){
            arr.add(A[i][0]);
            dep.add(A[i][1]);
        }
        Collections.sort(arr);
        Collections.sort(dep);
        int count = 0 , i=0 , j=0;
        while(i<row && j<row){
            if(arr.get(i)<dep.get(j)){
                count++;
                i++;
            }else if(arr.get(i)>dep.get(j)){
                count--;
                j++;
            }else{
                i++;
                j++;
            }
            max = Math.max(max,count);
        }
        return max;
    }
}
