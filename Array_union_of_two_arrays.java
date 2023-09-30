//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //Taking input using class Scanner
		Scanner sc=new Scanner(System.in);
		
		//Taking total count of testcases
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    
		    int n,m;
		    
		    //taking size of array a
		    n=sc.nextInt();
		    
		    //taking size of array b
		    m=sc.nextInt();
		    
		    //Creating 2 array of size n and m
		    int a[]=new int[n];
		    int b[]=new int[m];
		    
		    //inserting elements to array a
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    
		    //inserting elements to array b
		    for(int i=0;i<m;i++)
		    {
		        b[i]=sc.nextInt();
		    }
		    Solution ob=new Solution();
		    //calling doUnion method and printing the results
		    System.out.println(ob.doUnion(a,n,b,m));
		}
		
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int doUnion(int a[], int n, int b[], int m) 
    {
        //Your code here
        //formula of union is total -common
        
        /*ArrayList<Integer> arr=new ArrayList<>();
        ArrayList<Integer> brr=new ArrayList<>();
        for(Integer it:a){
            arr.add(it);
        }
        int common=0;
        for(Integer it:b){
            if(arr.contains(it)){
                common++;
            }
        }*/
        
        //use mergesort type merging
        /*int x1=0,x2=0;
        ArrayList<Integer> merge=new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);
        while(x1<n && x2<m){
            if(a[x1]<b[x2]){
                merge.add(a[x1++]);
            }else if(a[x1]>b[x2]){
                merge.add(b[x2++]);
            }else if(a[x1]==b[x2]){
                merge.add(a[x1]);
                x1++;
                x2++;
            }    
        }
        
        while(x1<n){
            merge.add(a[x1++]);
        }
        while(x2<m){
            merge.add(b[x2++]);
        }
        return merge.size();*/
        HashSet<Integer> h=new HashSet<>();
        for(Integer it:a){
            h.add(it);
            
        }
        
        for(Integer it:b){
            h.add(it);
            
        }
        return h.size();
    }
}