/*

Problem Description

Given a sorted array A and a target value B, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

*/

public class Solution {
    public int searchInsert(ArrayList<Integer> a, int target) {
        int low =0,high = a.size()-1;
        if(a.get(low)>target) return low;
        if(a.get(high)<target) return high+1;
        while(low<=high){
            int mid = low +(high-low)/2;
            if(a.get(mid)== target) return mid;
            if(a.get(mid)<target) low = mid+1;
            else high = mid-1;
        }
        return low;
    }
}
