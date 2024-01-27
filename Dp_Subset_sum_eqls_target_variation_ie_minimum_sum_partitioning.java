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
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    if(n==2){
	        return Math.abs(arr[0]-arr[1]);
	    }
	    int target=0;
	    for(int i=0;i<n;i++)target+=arr[i];
	    return f(arr,n-1,Integer.MAX_VALUE,target);
	} 
	int f(int arr[],int ind,int min,int target){
	    if(target==0){
	        return 0;
	    }
	    if(ind==0){
	        return Math.min(min,Math.abs(target-2*arr[ind]));
	    }
	    int take=f(arr,ind-1,min,target-2*arr[ind]);
	    int notTake=f(arr,ind-1,min,target);
	    
	    return Math.min(min,Math.min(take,notTake));
	}
}
