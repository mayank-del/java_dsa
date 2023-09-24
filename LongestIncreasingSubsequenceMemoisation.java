//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        int dp[][]=new int[size][size+1];
        for(int i=0;i<size;i++){
            for(int j=0;j<size+1;j++){
                dp[i][j]=-1;
            }
        }
        
        return f(a,0,-1,size-1,dp);
        
    }
    static int f(int[] arr,int ind, int prev,int n,int dp[][]){
        if(ind==n+1) return 0;
        if(dp[ind][prev+1]!=-1) return dp[ind][prev+1];
        int len=0+f(arr,ind+1,prev,n,dp);
        //int take=0;
        
        if(prev==-1|| arr[ind]>arr[prev]){
            len=Math.max(len,1+f(arr,ind+1,ind,n,dp));
        }
        return dp[ind][prev+1] = len;
    }
} 