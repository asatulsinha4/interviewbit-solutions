/*

Problem Description

You are in an infinite 2D grid where you can move in any of the 8 directions

 (x,y) to 
    (x+1, y), 
    (x - 1, y), 
    (x, y+1), 
    (x, y-1), 
    (x-1, y-1), 
    (x+1,y+1), 
    (x-1,y+1), 
    (x+1,y-1) 
You are given a sequence of points and the order in which you need to cover the points.. Give the minimum number of steps in which you can achieve it. You start from the first point.

NOTE: This question is intentionally left slightly vague. Clarify the question by trying out a few cases in the “See Expected Output” section.



Input Format
Given two integer arrays A and B, where A[i] is x coordinate and B[i] is y coordinate of ith point respectively.



Output Format
Return an Integer, i.e minimum number of steps.



Example Input
Input 1:

 A = [0, 1, 1]
 B = [0, 1, 2]


Example Output
Output 1:

 2
*/

public class Solution {
    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int result = 0;
        for(int i=0;i<A.size()-1;i++){
            int x = A.get(i+1) - A.get(i);
            int y = B.get(i+1) - B.get(i);
            int step = 0;
            if ( x == 0){
                step = y;
            }else{
                int tan = y/x;
                tan = tan > 0 ? tan : -tan;
                if(tan < 1){
                    step = x;
                }else{
                    step = y;
                }
            }
            //step = step > 0 ? step : -step;
            result = result + Math.abs(step);
        }
        return result;
    }
}
