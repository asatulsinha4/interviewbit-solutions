/*

Problem Description

Given a string A and integer B, what is maximal lexicographical stringthat can be made from A if you do atmost B swaps.

Problem Constraints
1 <= |A| <= 9

A contains only digits from 0 to 9.

1 <= B <= 5

Input Format
First argument is string A.

Second argument is integer B.

Output Format
Return a string, the naswer to the problem.



Example Input
Input 1:

A = "254"
B = 1
Input 2:

A = "254'
B = 2


Example Output
Output 1:

 524
Output 2:

 542


Example Explanation
Explanation 1:

 Swap 2 and 5.
Explanation 2:

Swap 2 and 5 then swap 4 and 2.
*/

public class Solution {
    int max=0;
    
    void swap(char[] A, int i, int j){
        char temp=A[i];
        A[i]=A[j];
        A[j]=temp;
    }
    
    void generate(char[] A, int B){
        if(B==0){
            return;
        }
        
        for (int i = 0; i < A.length - 1; i++){
            for (int j = i + 1; j < A.length; j++) {
                if(A[j]>A[i]){
                    swap(A,j,i);
                    
                    int temp = Integer.parseInt(String.valueOf(A));
                    max=Math.max(max,temp);
                    
                    generate(A,B-1);
                    swap(A,j,i);
                }    
            }
        } 
    }
    
    public String solve(String s, int B) {
        char[] A = s.toCharArray();
        generate(A,B);
        return String.valueOf(max);
    }
}
