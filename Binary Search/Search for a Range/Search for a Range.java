/*

Given a sorted array of integers A(0 based index) of size N, find the starting and ending position of a given integar B in array A.

Your algorithm’s runtime complexity must be in the order of O(log n).

Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].

For Example

Input 1:
    A = [5, 7, 7, 8, 8, 10]
    B = 8
Output 1:
    [3, 4]
Explanation 1:
    First occurence of 8 in A is at index 3
    Second occurence of 8 in A is at index 4
    ans = [3, 4]

Input 2:
    A = [5, 17, 100, 111]
    B = 3
Output 2:
    [-1, -1]

*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> searchRange(final List<Integer> A, int x) {
        ArrayList<Integer> ans = new ArrayList<>();
        int m;
        m = binarySearch(A,x,-1);
        ans.add(m);
        m = binarySearch(A,x,1);
        ans.add(m);
        return ans;
    }
    
    public int binarySearch(final List<Integer> A, int x, int d){
        int l=0, r=A.size()-1, ans=-1;
        while(l<=r){
            int m = (l+r)/2;
            if(A.get(m) > x){
                r = m - 1;
            }else if(A.get(m) < x){
                l = m+1;
            }else{
                ans = m;
                if(d>0) l = m + 1;
                else r = m - 1;
            }
        }
        return ans;
    }
}
