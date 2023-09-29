//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] a) {

        // Your code here
        int n=a.length;
        int m=a[0].length;
        boolean vis[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            if(a[i][0]==1 && vis[i][0]==false){
                dfs(i,0,a,vis);
            }
            if(a[i][m-1]==1 && vis[i][m-1]==false){
                dfs(i,m-1,a,vis);
            }
        }
        for(int j=0;j<m;j++){
            if(a[0][j]==1 && vis[0][j]==false){
                dfs(0,j,a,vis);
            }
            if(a[n-1][j]==1 && vis[n-1][j]==false){
                dfs(n-1,j,a,vis);
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==false && a[i][j]==1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    void dfs(int row,int col,int a[][],boolean vis[][]){
        //vis[i][j]=true;
        int delr[]={-1,1,0,0};
        int delc[]={0,0,1,-1};
        vis[row][col]=true;
        for(int i=0;i<4;i++){
            int nrow=row+delr[i];
            int ncol=col+delc[i];
            if(nrow>=0 && nrow<a.length && ncol>=0 && ncol<a[0].length && vis[nrow][ncol]==false &&a[nrow][ncol]==1){
                dfs(nrow,ncol,a,vis);
            }
        }
    }
}