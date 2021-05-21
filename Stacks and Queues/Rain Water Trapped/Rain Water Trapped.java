/*

Given an integer array A of non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.

*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int trap(final List<Integer> A) {
        int n = A.size();
        int []left = new int[n];
        int []right = new int[n];
        left[0] = A.get(0);
        right[n-1] = A.get(n-1);
        for(int i=1;i<n;i++){
            left[i] = Math.max(left[i-1],A.get(i));
            right[n-1-i] = Math.max(right[n-i],A.get(n-1-i));
        }
        int sum = 0;
        for(int i=0;i<n;i++){
            sum = sum + Math.min(left[i],right[i]) - A.get(i);
        }
        return sum;
    }
}
