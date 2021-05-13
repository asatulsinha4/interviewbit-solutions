/*

Given an array of integers A of size N and an integer B.

array A is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).

You are given a target value B to search. If found in the array, return its index, otherwise return -1.

You may assume no duplicate exists in the array.

*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int search(final List<Integer> A, int B) {
        int p = 0;
        int l = 0 , r = A.size()-1;
        int ans = 0;
        if(A.get(r)<A.get(l)){
            while(l<=r){
                int m = (l+r)/2;
                if(A.get(m)<A.get(r) && A.get(m) < A.get(l)){
                    if(A.get(m)<A.get(m-1)){
                        p = m;
                        break;
                    }else{
                        r--;
                    }
                }else if(A.get(m) > A.get(l) && A.get(m) > A.get(r)){
                    if(A.get(m)>A.get(m+1)){
                        p = m+1;
                        break;
                    }else{
                        l++;
                    }
                }
            }
            if(B>=A.get(0)){
                ans = binarySearch(A,0,p-1,B);
            }else{
                ans = binarySearch(A,p,A.size()-1,B);
            }
        }else{
            ans = binarySearch(A,0,A.size()-1,B);
        }
        return ans;
    }
    
    public int binarySearch(final List<Integer> A, int start, int end, int target){
        while(start<=end){
            int m = (start+end)/2;
            if(A.get(m) == target) return m;
            if(A.get(m)>target) end = m-1;
            if(A.get(m) < target) start = m+1;
        }
        return -1;
    }
}
