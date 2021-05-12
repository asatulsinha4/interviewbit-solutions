/*

There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

1. Each child must have at least one candy.
2. Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Input 1:
    A = [1, 2]

Output 1:
    3

Explanation 1:
    The candidate with 1 rating gets 1 candy and candidate with rating cannot get 1 candy as 1 is its neighbor. 
    So rating 2 candidate gets 2 candies. In total, 2 + 1 = 3 candies need to be given out.

Input 2:
    A = [1, 5, 2, 1]

Output 2:
    7

Explanation 2:
    Candies given = [1, 3, 2, 1]
    
    */

public class Solution {
    public int candy(ArrayList<Integer> A) {
        int sum = 0 , n = A.size();
        int []arr = new int[n];
        Arrays.fill(arr,1);
        for(int i=1;i<n;i++){
            if(A.get(i) > A.get(i-1)){
                arr[i] = arr[i-1]+1;
            }
        }
        for(int i=n-2;i>=0;i--){
            if(A.get(i)>A.get(i+1)){
                arr[i] = Math.max(arr[i] , arr[i+1]+1);
            }
        }
        for(Integer i : arr){
            sum = sum + i;
        }
        return sum;
    }
}
