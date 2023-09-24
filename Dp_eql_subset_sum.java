//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[])
    {
        // code here
        int sum=0;
        for(int i=0;i<N;i++){
            sum+=arr[i];
        }
        
        if(sum%2!=0) return 0;
        
        if(f(arr,N-1,sum/2)) return 1;
        else return 0;
    }
    static boolean f(int arr[],int ind,int sum){
        if(sum==0){
            return true;
        }
        
        if(ind==0){
            return (arr[ind]==sum);
        }
        
        boolean notPick=f(arr,ind-1,sum);
        boolean pick=false;
        if(sum-arr[ind]>=0)
            pick=f(arr,ind-1,sum-arr[ind]);
            
        return pick || notPick;
    }
}

///////////////// Memoisation  ///////////////

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[])
    {
        // code here
        int sum=0;
        for(int i=0;i<N;i++){
            sum+=arr[i];
        }
        
        if(sum%2!=0) return 0;
        int dp[][]=new int[N][(sum/2)+1];
        for(int i=0;i<N;i++){
            for(int j=0;j<=sum/2;j++){
                dp[i][j]=-1;
            }
        }
        if(f(arr,N-1,sum/2,dp)) return 1;
        else return 0;
    }
    static boolean f(int arr[],int ind,int sum,int dp[][]){
        if(sum==0){
            return true;
        }
        
        if(ind==0){
            return (arr[ind]==sum);
        }
        if(dp[ind][sum]!=-1)
            return dp[ind][sum]==0?false:true;
        
        boolean notPick=f(arr,ind-1,sum,dp);
        boolean pick=false;
        if(sum-arr[ind]>=0)
            pick=f(arr,ind-1,sum-arr[ind],dp);
            
        dp[ind][sum] = pick||notPick ? 1:0 ;  
        return pick || notPick;
    }
}