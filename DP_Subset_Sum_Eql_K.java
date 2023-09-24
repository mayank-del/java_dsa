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
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{
    int mod = (int)1e9+7;  
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    int dp[][]=new int[n+1][sum+1];
	    
	    for(int i=0;i<=n;i++){
	        for(int j=0;j<=sum;j++){
	            dp[i][j]=-1;
	        }
	    }
	    return f(arr,n,sum,dp)%mod;
	    
	}
	int f(int arr[],int ind,int sum,int dp[][]){
	   if(dp[ind][sum]!=-1) return dp[ind][sum];
	    if(ind==0 && sum>0){
	         return 0;
	    }
	    else if(ind==1){
	        if(sum==0){
	            if(arr[0]==0) return 2;
	            else return 1;
	        }else{
	            if(arr[0]==sum) return 1;
	            else return 0;
	        }
	    }else if(ind==0 && sum==0) return 1;
	    
	    
	    int ans=f(arr,ind-1,sum,dp);
	    
	    if(sum-arr[ind-1]>=0)
	       ans+=f(arr,ind-1,sum-arr[ind-1],dp);
	    
	   return dp[ind][sum]=ans%mod; 
	}
}