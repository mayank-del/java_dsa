//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maximumPath(int N, int mat[][])
    {
        // code here
        int row=mat.length;
        int col=mat[0].length;
        int maximum=0;
        int dp[][]=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<row;j++){
                dp[i][j]=-1;
            }
        }
        for(int i=0;i<col;i++)
            maximum=Math.max(maximum,f(mat,0,i,dp));
        
        return maximum;
    }
    static int f(int mat[][],int i, int j,int dp[][]){
        if(j<0 || j>=mat[0].length){
            return Integer.MIN_VALUE;
        }
        
        if(i==mat.length-1) return mat[i][j];
        if(dp[i][j]!=-1) return dp[i][j];
        
        int left=mat[i][j]+f(mat,i+1,j-1,dp);
        int down=mat[i][j]+f(mat,i+1,j,dp);
        int right=mat[i][j]+f(mat,i+1,j+1,dp);
        
        return dp[i][j]=Math.max(left,Math.max(down,right));
    }
}