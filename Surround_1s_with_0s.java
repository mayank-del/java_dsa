//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            int ans = ob.Count(matrix);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int  Count(int[][] matrix)
    {
        //All 8 directions
        
        int dx[]={0,0, -1,1,-1,1, 1,-1};
        int dy[]={1,-1, -1,1,1,-1, 0,0};
        
        int n=matrix.length;
        int m=matrix[0].length;
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int count=0;
                for(int z=0;z<8;z++){
                    int nrow=i+dx[z];
                    int ncol=j+dy[z];
                    
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && matrix[nrow][ncol]==0 && matrix[i][j]==1){
                        count++;
                    }
                }
                if(count !=0 && count%2==0){
                    res+=1;
                }
            }
        }
        
        
        return res;
        
    }
}