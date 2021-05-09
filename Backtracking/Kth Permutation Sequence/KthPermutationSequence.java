/*
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3 ) :

1. "123"
2. "132"
3. "213"
4. "231"
5. "312"
6. "321"
Given n and k, return the kth permutation sequence.

For example, given n = 3, k = 4, ans = "231"
*/
public class Solution {
    //public int[]arr;
    public String getPermutation(int A, int B) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=1;i<=A;i++){
            arr.add(i);
        }
        if(A==1) return String.valueOf(1);
        A--;
        int n = 0;
        if(A>12){
            n = Integer.MAX_VALUE;
        }else{
            n = fact(A);
        }
        String s = "";
        boolean last = false;
        while(A>0 && n>0){
            int q = B/n;
            if(B%n == 0 && B!=0){
                q--;
                last = true;
            }
            s = s + String.valueOf(arr.get(q));
            arr.remove(q);
            if(last){
                Collections.reverse(arr);
                for(Integer i: arr){
                    s = s + String.valueOf(i);
                }
                break;
            }
            B = B%n;
            n = n/A;
            A--;
            if(A>12){
                n = Integer.MAX_VALUE;
            }else if( n == (Integer.MAX_VALUE)/13 && A == 12){
                n = fact(12);
            }
        }
        return s;
    }
    
    public int fact(int n){
        int ans = 1;
        while(n > 0){
            ans = ans*n;
            n--;
        }
        return ans;
    }
}
