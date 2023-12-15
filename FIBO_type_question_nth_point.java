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
            Solution ob = new Solution();
            int ans = ob.nthPoint(n);
            System.out.println(ans);            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int nthPoint(int n)
    {
        // Code here
        
        int fib0=1,fib1=1;
        int num=0;
        if(n==0||n==1)return 1;
        for(int i=2;i<=n;i++){
            num=fib1+fib0;
            fib0=fib1;
            fib1=num % (int)(1e9 + 7);
        }
        
        return num%(int)(1e9+7);
    }
}