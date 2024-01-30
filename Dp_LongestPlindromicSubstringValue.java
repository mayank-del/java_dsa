//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static String longestPalin(String s){
        // code here
    
        
        StringBuilder retBuild=new StringBuilder();
        int maxm=1;
        int n=s.length();
        for(int i=0;i<n-1;i++){
            
            
            for(int j=i+1;j<n;j++){
                
                
                String s1=s.substring(i,j+1);
                StringBuilder reverseStr=new StringBuilder(s1);
                reverseStr.reverse();
                String conv=reverseStr.toString();
                
                if(conv.equals(s1)){
                    
                    
                    if(maxm<s1.length()){
                        maxm=s1.length();
                        retBuild=new StringBuilder(s1);
                    }   
                }
            }
        }
        String returnString=retBuild.toString();
        if(returnString.length()==0) returnString+=s.charAt(0);
        return returnString;
    }
}