//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driver
{
    public static void main(String args[]) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            
            int  m= sc.nextInt();
            int []b = new int[m];
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
            
            double res = new GFG().medianOfArrays(n, m, a, b);
            
            if (res == (int)res) System.out.println ((int)res);
            else System.out.println (res);
        }
    		
	} 
}
// } Driver Code Ends


//User function Template for Java

class GFG 
{ 
    static double medianOfArrays(int n, int m, int a[], int b[]) 
    {
        // Your Code Here
        int merge[]=new int[n+m];
        int x=0;
        int ind=0;
        int ind2=0;
        while(ind<n && ind2<m){
            if(a[ind]>=b[ind2]){
                merge[x++]=b[ind2++];
            }else{
                merge[x++]=a[ind++];
            }
        }
        while(ind<n){
            merge[x++]=a[ind++];
        }
        while(ind2<m){
            merge[x++]=b[ind2++];
        }
        int sum=0;
        for(int i=0;i<m+n;i++){
            sum+=merge[i];
        }
        double res=0;
        if(merge.length%2==0) res=(double)(merge[merge.length/2] + merge[merge.length/2 - 1])/2;
        else res= (double)merge[merge.length/2];
        return res;
    }
}