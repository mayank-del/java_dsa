//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSum(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int maxSum(int n) 
    { 
        //code here.
        int dp[]=new int[n+1];
            // base condition
            dp[0] = 0;
            if(n==0)return 0;
            dp[1] = 1;
            if(n==1) return 1;
            // Fill in bottom-up manner
            for(int i=2;i<=n;++i)
                dp[i] = Math.max(dp[i/2]+dp[i/3]+dp[i/4],i);
            return dp[n];
    } 
}
