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
                    String s = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.isReversible(s, n));
                }
                
        }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int isReversible(String str, int n) 
    { 
     //complete the function here
     
     String copy=str;
     if(f(copy,str)) return 1;
     else return 0;
     
    }
    boolean f(String copy,String str){
        if(str.length()==1)
            return true;
        StringBuilder sb=new StringBuilder(str);
        sb.reverse();
        
        String srev=sb.toString();
        int mid=str.length()/2;
        if(copy.contains(srev) && f(copy,str.substring(0,mid)) && f(copy,str.substring(mid))) return true;
        else return false;
        
    }
    
}