/*
Given a string s, partition s such that every string of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["a","a","b"]
    ["aa","b"],
  ]
*/

public class Solution {
    public ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        helper(ans, a, 0 , new ArrayList<String>());
        return ans;
    }
    
    public void helper(ArrayList<ArrayList<String>> ans, String a, int curr , ArrayList<String> temp){
        int n = a.length();
        String s = "";
        if(curr == n) ans.add(temp);
        while(curr<n){
            s = s + Character.toString(a.charAt(curr));
            curr++;
            if(isPalindrome(s)){
                ArrayList<String> n_temp = new ArrayList<>();
                n_temp.addAll(temp);
                n_temp.add(s);
                helper(ans,a,curr,n_temp);
            }
        }
    }
    
    public boolean isPalindrome(String s){
        int n = s.length();
        if(n==1) return true;
        int l = n/2 + 1;
        for(int i=0;i<l;i++){
            if(s.charAt(i) != s.charAt(n-1-i)) return false;
        }
        return true;
    }
}
