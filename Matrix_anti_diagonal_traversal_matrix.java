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
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            
            String input_line[] = br.readLine().trim().split("\\s+");
            int[][] matrix = new int[n][n];
            for(int i=0; i<n; i++) {
                for (int j = 0; j < n; ++j) {
                    matrix[i][j] = Integer.parseInt(input_line[i * n + j]); 
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.antiDiagonalPattern(matrix);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends



//User function Template for Java

class Solution
{
    public int[] antiDiagonalPattern(int[][] matrix)
    {
        // Code here
        int i=0,j=0;
        int res[]=new int[matrix.length * matrix[0].length];
        int it=0;
        while(j<matrix[0].length){
            int k=j;
            i=0;
            while(k>=0 && i<matrix.length){
                res[it++]=matrix[i][k];
                k--;
                i++;
            }
            j++;
            
        }
        i=1;
        while(i<matrix.length){
            int k=i;
            j=matrix[0].length-1;
            while(k<matrix.length){
                res[it++]=matrix[k][j];
                k++;
                j--;
            }
            i++;
            
        }
        return res;
    }
}