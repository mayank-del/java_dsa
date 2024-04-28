//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine().trim());
        while(t-->0)
        {
            int n=Integer.parseInt(in.readLine().trim());
            int a[]=new int[n];
            String s[]=in.readLine().trim().split(" ");
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(s[i]);
            }
            Solution ob=new Solution();
            int ans[]=ob.frequency(n,a);
            for(int i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int[] frequency(int n,int a[])
    {
        HashMap<Integer,Integer>h=new HashMap<>();
        for(int i=n-1;i>=0;i--){
            h.put(a[i],h.getOrDefault(a[i],0)+1);
            int val=h.getOrDefault(a[i],0);
            
            a[i]=val;
        }
        
        return a;
    }
}