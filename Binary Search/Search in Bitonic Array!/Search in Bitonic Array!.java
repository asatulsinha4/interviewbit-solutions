/*

Problem Description

Given a bitonic sequence A of N distinct elements, write a program to find a given element B in the bitonic sequence in O(logN) time.

NOTE:

A Bitonic Sequence is a sequence of numbers which is first strictly increasing then after a point strictly decreasing.

Example Input
Input 1:

 A = [3, 9, 10, 20, 17, 5, 1]
 B = 20
Input 2:

 A = [5, 6, 7, 8, 9, 10, 3, 2, 1]
 B = 30


Example Output
Output 1:

 3
Output 2:

 -1

*/

public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int p=0;
        int l=0 , r = A.size()-1;
        while(l<=r){
            int m = (l+r)/2;
            if(A.get(m) > A.get(m-1) && A.get(m) < A.get(m+1)) l=m+1;
            if(A.get(m) > A.get(m+1) && A.get(m) < A.get(m-1)) r=m-1;
            if(A.get(m) > A.get(m-1) && A.get(m) > A.get(m+1)){
                p = m+1;
                break;
            }
        }
        //System.out.print("p: "+p+" ");
        int ans1 = i_binarySearch(A,0,p-1,B);
        //System.out.print("ans1: "+ans1+" ");
        int ans2 = d_binarySearch(A,p,A.size()-1,B);
        //System.out.print("ans2: "+ans2+" ");
        if(ans1==-1 && ans2==-1) return -1;
        return Math.max(ans1,ans2);
    }
    
    public int i_binarySearch(ArrayList<Integer> A, int start, int end, int target){
        
        while(start<=end){
            int m = (start+end)/2;
            if(A.get(m)==target) return m;
            if(A.get(m)>target) end = m-1;
            if(A.get(m)<target) start=m+1;
        }
        return -1;
    }
    
    public int d_binarySearch(ArrayList<Integer> A, int start, int end, int target){
        
        while(start<=end){
            int m = (start+end)/2;
            if(A.get(m)==target) return m;
            if(A.get(m)>target) start=m+1;
            if(A.get(m)<target) end=m-1;
        }
        return -1;
    }
}
