/*
There is a rectangle with left bottom as  (0, 0) and right up as (x, y). There are N circles such that their centers are inside the rectangle.
Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without touching any circle.
*/

public class Solution {
    public  String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
        Graph g = new Graph(A,B,D,E,F);
        if(g.BFS()) return "YES";
        return "NO";
    }
    
    class Graph{
        public HashMap<String, HashSet<String>> map;
        private int x, y, R;
        private ArrayList<Integer> X, Y;
        public HashSet<String> inValid;
        Graph(int x, int y, int r, ArrayList<Integer> E, ArrayList<Integer> F){
            this.x = x;
            this.y = y;
            this.R = r;
            this.X = new ArrayList<>(E);
            this.Y = new ArrayList<>(F);
            map = new HashMap<>();
            inValid = new HashSet<>();
            populateGraph();
            /*for(String key : map.keySet()){
                System.out.print(key+"  ");
            }*/
        }
        
        public void addEdge(String src, String dest){
            map.putIfAbsent(src,new HashSet<>());
            map.get(src).add(dest);
            map.putIfAbsent(dest,new HashSet<>());
            map.get(dest).add(src);
        }
        
        public boolean isValid(int a, int b){
            if(a < 0 || a > this.x) return false;
            if(b < 0 || b > this.y) return false;
            if(insideCircle(a,b)) return false;
            return true;
        }
        
        public boolean insideCircle(int a, int b){
            String src = String.valueOf(a)+","+String.valueOf(b);
            if(inValid.contains(src)) return true;
            for(int i=0;i<this.X.size();i++){
                int m = this.X.get(i) - a;
                m = m*m;
                int n = this.Y.get(i) - b;
                n = n*n;
                double d = Math.sqrt((m+n));
                if(d <= this.R){
                    inValid.add(src);
                    return true;
                }
            }
            return false;
        }
        
        public void populateGraph(){
            for(int i=0;i<=this.x;i++){
                for(int j=0;j<=this.y;j++){
                    fillGraph(i,j);
                }
            }
        }
        
        public void fillGraph(int x, int y){
            if(!isValid(x,y)) return;
            String src = String.valueOf(x)+","+String.valueOf(y);
            if(isValid((x+1),y)){
                String dest = String.valueOf((x+1))+","+String.valueOf(y);
                addEdge(src,dest);
                //fillGraph((x+1),y);
            }
            if(isValid((x+1),(y+1))){
                String dest = String.valueOf((x+1))+","+String.valueOf((y+1));
                addEdge(src,dest);
                //fillGraph((x+1),(y+1));
            }
            if(isValid((x+1),(y-1))){
                String dest = String.valueOf((x+1))+","+String.valueOf((y-1));
                addEdge(src,dest);
                //fillGraph((x+1),(y-1));
            }
            if(isValid(x,(y+1))){
                String dest = String.valueOf((x))+","+String.valueOf((y+1));
                addEdge(src,dest);
                //fillGraph((x),(y+1));
            }
            if(isValid(x,(y-1))){
                String dest = String.valueOf((x))+","+String.valueOf((y-1));
                addEdge(src,dest);
                //fillGraph((x),(y-1));
            }
            if(isValid((x-1),y)){
                String dest = String.valueOf((x-1))+","+String.valueOf(y);
                addEdge(src,dest);
                //fillGraph((x-1),y);
            }
            if(isValid((x-1),(y+1))){
                String dest = String.valueOf((x-1))+","+String.valueOf((y+1));
                addEdge(src,dest);
                //fillGraph((x-1),(y+1));
            }
            if(isValid((x-1),(y-1))){
                String dest = String.valueOf((x-1))+","+String.valueOf((y-1));
                addEdge(src,dest);
                //fillGraph((x-1),(y-1));
            }
        }
        
        public boolean BFS(){
            HashSet<String> visited = new HashSet<>();
            String dst=String.valueOf(this.x)+","+String.valueOf(this.y);
            Queue<String> queue = new LinkedList<>();
            if(!map.containsKey("0,0")) return false;
            queue.add("0,0");
            visited.add("0,0");
            while(!queue.isEmpty()){
                String s = queue.remove();
                //System.out.print(s+"  ");
                if(map.get(s).size()!=0){
                    for(String tmp : map.get(s)){
                        if(!visited.contains(tmp)){
                            visited.add(tmp);
                            queue.add(tmp);
                        }
                    }
                }
                if(visited.contains(dst)) return true;
            }
            return false;
        }
    }
}
