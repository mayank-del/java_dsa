//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.countMin(str));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int countMin(String str)
    {
        // code here
        StringBuilder sb=new StringBuilder(str);
        sb=sb.reverse();
        String rev=sb.toString();
        int n=str.length();
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return n-f(str,n-1,rev,n-1,dp);
    }
    static int f(String s,int ind,String t,int ind2,int dp[][]){
        if(ind<0 || ind2<0){
            return 0;
        }
        if(dp[ind][ind2]!=-1) return dp[ind][ind2];
        if(s.charAt(ind)==t.charAt(ind2)){
            return dp[ind][ind2]=1 + f(s,ind-1,t,ind2-1,dp);
        }
        
        return dp[ind][ind2]=Math.max(f(s,ind-1,t,ind2,dp),f(s,ind,t,ind2-1,dp));
    }
    }