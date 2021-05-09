/*

For Given Number N find if its COLORFUL number or not

Return 0/1

COLORFUL number:

A number can be broken into different contiguous sub-subsequence parts. 
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. 
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
Example:

N = 23
2 3 23
2 -> 2
3 -> 3
23 -> 6
this number is a COLORFUL number since product of every digit of a sub-sequence are different. 

Output : 1
*/

public class Solution {
    public int colorful(int A) {
        HashSet<Integer> ht = new HashSet<Integer>();
        String S = String.valueOf(A);
        for(int i=0;i<S.length();i++){
            for(int j=i;j<S.length();j++){
                int temp = mul(S.substring(i,j+1));
                //System.out.print("sub ="+S.substring(i,j+1)+" "+temp+" ");
                if(ht.contains(temp)){
                    return 0;
                }
                ht.add(temp);
            }
        }
        return 1;
    }
    
    public static int mul(String S){
        int n = Integer.parseInt(S);
        int temp = 1;
        while(n>0){
            temp = temp * (n%10);
            n = n/10;
        }
        return temp;
    }
}
