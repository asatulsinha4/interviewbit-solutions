/*

Given an integar A.

Compute and return the square root of A.

If A is not a perfect square, return floor(sqrt(A)).

DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY


*/

public class Solution {
    public int sqrt(int A) {
        long output = 0;
        long l = 0;
        long r = A;
        while(l<=r){
            long m = (l+r)/2;
            //System.out.print(" m = "+m+" ");
            double temp = m*m;
            if(temp == A){
                return (int)m;
            }else if(temp > A){
                r = m-1;
            }else {
                output = m;
                l = m+1;
            }
        }
        //int output = (int)Math.sqrt(A);
        return (int)output;
    }
}
