/*

Given a matrix of integers A of size N x M and an integer B.

Write an efficient algorithm that searches for integar B in matrix A.

This matrix A has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Return 1 if B is present in A, else return 0.

For Example

Input 1:
    A = 
    [ [1,   3,  5,  7],
      [10, 11, 16, 20],
      [23, 30, 34, 50]  ]
    B = 3
Output 1:
    1

Input 2:
    A = [   [5, 17, 100, 111]
            [119, 120,  127,   131]    ]
    B = 3
Output 2:
    0
    
*/

public class Solution {
    public int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {
        int n = A.size();
        int m = A.get(0).size();
        ArrayList<Integer> E = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            E.add(A.get(i).get(m-1));
        }
        int in = Collections.binarySearch(E,B);
        in = in<0? -1*(in+1) : in;
        if(in == n) return 0;
        ArrayList<Integer> temp = (ArrayList<Integer>)A.get(in).clone();
        in = Collections.binarySearch(temp,B);
        if(in<0){
            return 0;
        }else{
            return 1;
        }
    }
}
