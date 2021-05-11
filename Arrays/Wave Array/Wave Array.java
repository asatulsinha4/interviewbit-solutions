/*

Given an array of integers, sort the array into a wave like array and return it,
In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....

Example

Given [1, 2, 3, 4]

One possible answer : [2, 1, 4, 3]
Another possible answer : [4, 1, 3, 2]

*/

public class Solution {
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        int n= A.size();
        int []a = A.stream().mapToInt(i -> i).toArray();
        Arrays.sort(a);
        for(int i=0;i<n-1;i++){
            if((i%2 == 0)&&(a[i] < a[i+1])){
                int temp = a[i]+a[i+1];
                a[i]=temp-a[i];
                a[i+1]=temp-a[i+1];
            }else if((i%2 == 1)&&(a[i] > a[i+1])){
                int temp = a[i]+a[i+1];
                a[i]=temp-a[i];
                a[i+1]=temp-a[i+1];
            }
        }
        A.clear();
        for(int i=0;i<n;i++){
            A.add(a[i]);
        }
        return A;
    }
}
