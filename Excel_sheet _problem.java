//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
    		System.out.println (new Solution().colName (n));
        }
        
    }
}

// Contributed By: Pranay Bansal 

// } Driver Code Ends


//User function Template for Java

class Solution
{
    String colName (long num)
    {
        // your code here
        StringBuilder str = new StringBuilder();

        for(;num>0;){
        
            str.insert(0,(char)('A'+ (num-1)%26));

            num=(num-1)/26;
        }

        return str.toString();
    }
}