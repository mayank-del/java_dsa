//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.minimumNumberOfDeletions(S));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minimumNumberOfDeletions(String S) {
        //your code here
        int n=S.length();
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        char ch[]=S.toCharArray();
        for(int i=0;i<n/2;i++){
            char temp=ch[i];
            ch[i]=ch[n-1-i];
            ch[n-i-1]=temp;
        }
        String T=new String(ch);
        
        int len=f(0,0,S,T,dp,n);
        
        return n-len;
    }
    
    static int f(int ind,int ind2,String s, String t,int dp[][],int n){
        if(ind==n || ind2==n){
            return 0;
        }
        
        
        if(dp[ind][ind2]!=-1){
            return dp[ind][ind2];
        }
        
        if(s.charAt(ind)==t.charAt(ind2)){
           return dp[ind][ind2]= 1+f(ind+1,ind2+1,s,t,dp,n);
        }else{
            return dp[ind][ind2]=Math.max(f(ind,ind2+1,s,t,dp,n),f(ind+1,ind2,s,t,dp,n));
        }
    }
}