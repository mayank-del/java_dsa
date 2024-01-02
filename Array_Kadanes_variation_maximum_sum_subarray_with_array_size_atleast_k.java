//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            long k = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            System.out.println(obj.maxSumWithK(a, n, k));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public long maxSumWithK(long a[], long n, long k)
    {
        long sum=0;
        
        int num=(int)n;
        int kd=(int)k;
        
        long maxm[]=new long[num];
        long res=Long.MIN_VALUE;
        
        //use kadane's
        for(int i=0;i<num;i++){
            sum+=a[i];
            if(sum<0){
                
                maxm[i]=sum;
                sum=0;
            }else{
                maxm[i]=sum;
            }
        }
        long exact_K=0;
        /*for(int i=0;i<num;i++){
            if(i<kd){
                sum+=a[i];
            }else{
                sum=sum+a[i]-a[i-kd];
                res=Math.max(res,Math.max(sum,sum+maxm[i-kd]));
            }
            
            
        }*/
        for(int i=0;i<kd;i++){
            exact_K+=a[i];
        }
        if(exact_K>res){
            res=exact_K;
        }
        
    
        
        for(int i=kd;i<num;i++){
            exact_K=exact_K+a[i]-a[i-kd];
            
            if(exact_K>res){
                res=exact_K;
            }
            long more_than_K=maxm[i-kd]+exact_K;
            if(more_than_K>res){
                res=more_than_K;
            }
        }
        
        return res;
    }
}