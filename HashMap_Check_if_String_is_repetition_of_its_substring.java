//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String s = sc.next();
            int k = sc.nextInt();
            int answer = new Solution().kSubstrConcat(n,s,k);
    		System.out.println(answer);
        }
        
    }
}

// Contributed By: Pranay Bansal

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int kSubstrConcat(int n, String s, int k)
    {
        // Your Code Here  
        if(n%k!=0){
            return 0;
        }
        
        HashMap<String,Integer> h=new HashMap<>();
        for(int i=0;i<n-k+1;i=i+k){
            String sub=s.substring(i,i+k); 
            h.put(sub,h.getOrDefault(sub,0)+1);
            
        }
        
        if(h.size()==2 || h.size()==1){
            return 1;
        }else {
            return 0;
        }
        
    }
}