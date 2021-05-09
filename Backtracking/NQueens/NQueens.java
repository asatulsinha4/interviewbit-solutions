/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

N Queens: Example 1

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens’ placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/

public class Solution {
    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        ArrayList<int[][]> storage = new ArrayList<>();
        for(int i=0;i<a;i++){
            generate(new int[a][a], a, 0, i, a-1,storage);
        }
        printChess(ans,storage,a);
        return ans;
    }
    
    public boolean isSafe(int i, int j, int a, int [][]chess){
        if(i<0 || i >=a || j<0 || j>=a) return false;
        if(chess[i][j]!=0) return false;
        return true;
    }
    
    public void fill(int [][]chess, int i, int j, int a){
        for(int k=0;k<a;k++){
            chess[i][k] = 1;
            chess[k][j] = 1;
        }
        //upper-right diagonal
        for(int x=i, y=j; x>=0 && y<a ; x-- , y++){
            if(((x+y) == (i+j)) && (chess[x][y] == 0)) chess[x][y] = 1;
        }
        //lower-right diagonal
        for(int x=i, y=j; x<a && y<a ; x++ , y++){
            if(((x-y) == (i-j)) && (chess[x][y] == 0)) chess[x][y] = 1;
        }
        //upper-left diagonal
        for(int x=i, y=j; x>=0 && y>=0 ; x-- , y--){
            if(((x-y) == (i-j)) && (chess[x][y] == 0)) chess[x][y] = 1;
        }
        //lower-left diagonal
        for(int x=i, y=j; x<a && y>=0 ; x++ , y--){
            if(((x+y) == (i+j)) && (chess[x][y] == 0)) chess[x][y] = 1;
        }
        chess[i][j] = 2;
    }
    
    public void generate(int [][]chess, int a,int x, int y, int n,ArrayList<int[][]> storage){
        int[][] copy_chess = Arrays.stream(chess).map(int[]::clone).toArray(int[][]::new);
        fill(copy_chess,x,y,a);
        if(n==0) storage.add(copy_chess);
        x++;
        for(int j=0;j<a;j++){
            if(isSafe(x ,j,a,copy_chess) && n>0){
                generate(copy_chess,a,x,j,n-1,storage);
            }
        }
        return;
    }
    
    public void printChess(ArrayList<ArrayList<String>> ans, ArrayList<int[][]> storage, int a){
        for(int [][]arr : storage){
            ArrayList<String> temp = new ArrayList<>();
            for(int i=0;i<a;i++){
                String s = "";
                for(int j=0;j<a;j++){
                    if(arr[i][j]==2){
                        s = s + "Q";
                    }else{
                        s = s + ".";
                    }
                }
                temp.add(s);
            }
            ans.add(temp);
        }
    }
}
