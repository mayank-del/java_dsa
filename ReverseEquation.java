//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            String s;
            s = in.readLine().trim();
            
            Solution ob = new Solution();
            
            out.println(ob.reverseEqn(s));    
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
   
    String reverseEqn(String S)
    {
        // your code here
        StringBuilder sb=new StringBuilder(S);
        StringBuilder res=new StringBuilder();
        Stack<String>st=new Stack<>();
        int start=0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='+' || S.charAt(i)=='-' || S.charAt(i)=='*' || S.charAt(i)=='/'){
                res.insert(0,S.substring(start,i));
                res.insert(0,""+S.charAt(i));
                start=i+1;
            }
        }
        res.insert(0,S.substring(start,S.length()));
        String r=res.toString();
        return r;
    }
}