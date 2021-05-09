/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



The digit 0 maps to 0 itself.
The digit 1 maps to 1 itself.

Input: Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Make sure the returned strings are lexicographically sorted.
*/

public class Solution {
    public static ArrayList<String> letterCombinations(String A) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "0");
        map.put(1, "1");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        ArrayList<String> ans = new ArrayList<>();
        helper(map,A,0, ans, "");
        return ans;
    }
    
    public static void helper(HashMap<Integer, String> map, String A,int curr, ArrayList<String> ans, String s){
        //String temp = "";
        int n = Character.getNumericValue(A.charAt(curr));
        char []c = map.get(n).toCharArray();
        curr++;
        for(int i=0;i<c.length;i++){
            String temp = s + Character.toString(c[i]);
            if(curr == A.length()){
                ans.add(temp);
            }else{
                helper(map,A,curr,ans,temp);
            }
        }
    }
}
