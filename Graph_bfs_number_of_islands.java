//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        ArrayList<Integer> arr=new ArrayList<>();
        Queue<Pair> q=new LinkedList<>();
        
        boolean vis[][]=new boolean[n][m];
        
        //vis[0][0]=true;
        q.add(new Pair(0,0));
        int cnt=0;
        for(int row = 0; row < n ; row++) {
            for(int col = 0; col < m ;col++) {
                // if not visited and is a land
                if(vis[row][col] == false && grid[row][col] == '1') {
                    cnt++; 
                    bfs(row, col, vis, grid); 
                }
            }
        }
        return cnt; 
    }
        /*while(!q.isEmpty()){
            
            //int node=q.remove();
            //arr.add(node);
            Pair p=q.remove();
            int first=p.first;
            int sec=this.sec;
            
            for(Integer it : adj.get(node)){
                if(!vis[it]){
                    q.add(it);
                    vis[it]=true;
                }
            }
        }
        return arr;*/
        
    private void bfs(int ro, int co, boolean[][] vis, char[][] grid) {
      vis[ro][co] = true; 
      Queue<Pair> q = new LinkedList<Pair>();
      q.add(new Pair(ro, co)); 
      int n = grid.length; 
      int m = grid[0].length; 
      
      // until the queue becomes empty
      while(!q.isEmpty()) {
          int row = q.peek().first; 
          int col = q.peek().second; 
          q.remove(); 
          
          // traverse in the neighbours and mark them if its a land 
          
          
          for(int delrow = -1; delrow<=1;delrow++) {
              for(int delcol = -1; delcol <= 1; delcol++) {
                  int nrow = row + delrow; 
                  int ncol = col + delcol; 
          // check if neighbour row and column is valid, and is an unvisited land
                  if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
                  && grid[nrow][ncol] == '1' && vis[nrow][ncol] == false) {
                      vis[nrow][ncol] = true; 
                      q.add(new Pair(nrow, ncol)); 
                  }
              }
          }
      }
    }
}


//Another solution, many days later


/* 
 * 
 * class Solution {
    public int countIslands(char[][] grid) {
        // Code here
        
       Queue<Pair> q=new LinkedList<>();
       int n=grid.length;
       int m=grid[0].length;
       boolean vis[][]=new boolean[n][m];
       int cnt=0;
       for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
               if(!vis[i][j] && grid[i][j]=='L'){
                   cnt++;
                   vis[i][j]=true;
                   q.add(new Pair(i,j));
                   bfs(grid,n,m,q,vis);
               }
           }
       }
       return cnt;
       
       
    }
    
    public void bfs(char grid[][],int n, int m,Queue<Pair> q, boolean vis[][]){
        
        //int delCoord[][]=[]
        while(!q.isEmpty()){
            
            Pair pr=q.remove();
            int x=pr.x;
            int y=pr.y;
            
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    int delx=x+i;
                    int dely=y+j;
                    
                    if(delx>=0 && delx<n && dely>=0 && dely<m && !vis[delx][dely] &&grid[delx][dely]=='L'){
                        q.add(new Pair(delx,dely));
                        vis[delx][dely]=true;
                    }
                }
            }
        }
    }
}

class Pair{
    int x;
    int y;
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}
 * 
 * 
 */