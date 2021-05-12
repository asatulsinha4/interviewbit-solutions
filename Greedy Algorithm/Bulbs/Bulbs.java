/*

N light bulbs are connected by a wire.

Each bulb has a switch associated with it, however due to faulty wiring, a switch also changes the state of all the bulbs to the right of current bulb.

Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs.

You can press the same switch multiple times.

Example:

Input 1:
    A = [1]

Output 1:
    0

Explanation 1:
    There is no need to turn any switches as all the bulbs are already on.

Input 2: 
    A = [0 1 0 1]

Output 2:
    4

Explanation 2:
	press switch 0 : [1 0 1 0]
	press switch 1 : [1 1 0 1]
	press switch 2 : [1 1 1 0]
	press switch 3 : [1 1 1 1]

*/

public class Solution {
    public int bulbs(ArrayList<Integer> A) {
        int count = 0;
        int []arr = A.stream().mapToInt(i->i).toArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0 && count%2==0){
                count++;
                //bulb_switch(arr , i);
            }
            if(arr[i] == 1 && count%2==1){
                count++;
            }
        }
        return count;
    }
    
    public void bulb_switch(int []arr , int i){
        if(i==arr.length-1) return;
        for(int j=i+1;j<arr.length;j++){
            if(arr[j]==0){
                arr[j] = 1;
            }else{
                arr[j] = 0;
            }
        }
    }
}
