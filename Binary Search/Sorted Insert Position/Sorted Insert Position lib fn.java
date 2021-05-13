/*

Problem Description

Given a sorted array A and a target value B, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.



**Problem Constraints**
1 <= |A| <= 100000

1 <= B <= 109

*/

public class Solution {
    public int searchInsert(ArrayList<Integer> a, int b) {
        int in = Collections.binarySearch(a,b);
        if(in>=0){
            return in;
        }else{
            return -1*(in+1);
        }
    }
}
