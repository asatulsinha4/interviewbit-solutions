/*
Given a string A denoting a stream of lowercase alphabets. You have to make new string B.

B is formed such that we have to find first non-repeating character each time a character is inserted 
to the stream and append it at the end to B. If no non-repeating character is found then append '#' at the end of B.
*/
public class Solution {
    public String solve(String A) {
        String B = "";
        int []arr = new int[26];
        // Arrays.fill(arr,0);
        Queue<Character> queue = new LinkedList<>();
        for(int i=0;i<A.length();i++){
            char c = A.charAt(i);
            int j = (int)c - (int)'a';
            queue.add(c);
            arr[j]++;
            char temp = '#';
            while(queue.size()!=0){
                if(arr[(int)queue.peek() - (int)'a'] > 1) queue.remove();
                else {
                    temp = queue.peek();
                    break;
                }
            }
            B = B + Character.toString(temp);
        }
        return B;
    }
}
