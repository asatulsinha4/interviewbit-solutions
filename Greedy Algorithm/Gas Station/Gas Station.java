/*

Given two integer arrays A and B of size N.
There are N gas stations along a circular route, where the amount of gas at station i is A[i].

You have a car with an unlimited gas tank and it costs B[i] of gas to travel from station i
to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the minimum starting gas station’s index if you can travel around the circuit once, otherwise return -1.

You can only travel in one direction. i to i+1, i+2, … n-1, 0, 1, 2.. Completing the circuit means starting at i and
ending up at i again.

*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
        int n = A.size();
        if(n==1){
            if(A.get(0)>= B.get(0)) return 0;
            return -1;
        }
        int ptr = 0 , ans=0 , c=0;
        boolean journey = false;
        while(true){
            c = A.get(ptr)+c-B.get(ptr);
            if(c>=0){
                ptr = (ptr+1)%n;
                journey = true;
            }else{
                ptr = (ans+1)%
                ans = ptr;
                c=0;
                journey = false;
            }
            if(ptr == ans && journey) break;
            if(ans==0 && !journey) return -1;
        }
        return ans;
    }
}
