/*
Given a string A consisting only of '(' and ')'.

You need to find whether parantheses in A is balanced or not ,if it is balanced then return 1 else return 0.

Input Format
First argument is an string A.

Output Format
Return 1 if parantheses in string are balanced else return 0.

*/

public class Solution {
    public int solve(String A) {
        Stack <String> st = new Stack<String>();
        A = A.trim();
        String s1 = "()";
        String s2 = "[]";
        String s3 = "{}";
        for(int i=0;i<A.length();i++){
            String s = Character.toString(A.charAt(i));
            char a = A.charAt(i);
            if(st.empty()){
                if(a == '(' || a=='[' || a=='{'){
                    st.push(s);
                    //System.out.print("line 11 s = "+s+" ");
                } else {
                    //System.out.print("line 10 char = "+s+" ");
                    return 0;
                }
            } else {
                String temp = st.peek();
                temp = temp + s;
                //System.out.print("line19 temp ="+temp+" ");
                if(temp.intern() == s1.intern() || temp.intern() == s2.intern() || temp.intern() == s3.intern()){
                    //System.out.print("line 20 last = "+st.peek()+" ");
                    st.pop();
                    //System.out.print("line 22 last = "+st.empty()+" ");
                }else{
                    //System.out.print("line 24 last = "+st.peek()+" ");
                    st.push(s);
                }
            }
        }
        //System.out.print("line 26 "+st.empty()+" last = "+st.peek()+" ");
        int r = st.empty() ? 1 : 0;
        return r;
    }
}
