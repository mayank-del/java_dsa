//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
        boolean vis[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            if(a[i][0]=='O' && vis[i][0]==false){
                dfs(i,0,a,vis);
            }
            if(a[i][m-1]=='O' && vis[i][m-1]==false){
                dfs(i,m-1,a,vis);
            }
        }
        for(int j=0;j<m;j++){
            if(a[0][j]=='O' && vis[0][j]==false){
                dfs(0,j,a,vis);
            }
            if(a[n-1][j]=='O' && vis[n-1][j]==false){
                dfs(n-1,j,a,vis);
            }
        }
        char res[][]=a;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==false && a[i][j]=='O'){
                    res[i][j]='X';
                }
            }
        }
        return res;
    }
    static void dfs(int row,int col,char a[][],boolean vis[][]){
        //vis[i][j]=true;
        int delr[]={-1,1,0,0};
        int delc[]={0,0,1,-1};
        vis[row][col]=true;
        for(int i=0;i<4;i++){
            int nrow=row+delr[i];
            int ncol=col+delc[i];
            if(nrow>=0 && nrow<a.length && ncol>=0 && ncol<a[0].length && vis[nrow][ncol]==false &&a[nrow][ncol]=='O'){
                dfs(nrow,ncol,a,vis);
            }
        }
    }
    
}