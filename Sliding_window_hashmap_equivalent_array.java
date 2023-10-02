//{ Driver Code Starts
//Initial Template for Java


//Initial Template for Java


import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


 
class Solution
{ 
    // Method to calculate distinct sub-array 
    static int countDistinctSubarray(int arr[], int n) 
    { 
        HashMap<Integer,Integer> h=new HashMap<>();
        
        for(int i=0;i<n;i++){
            h.put(arr[i],h.getOrDefault(arr[i],0)+1);
        }
        
        int dist=h.size();
        if(n==2 && dist==1) return 3;
        h=new HashMap<>();
        int count=0;
        int l=-1,r=-1;
        //acquire
        while(true){
            boolean f1=false,f2=false;
            while(r<n-1){
                r++;
                h.put(arr[r],h.getOrDefault(arr[r],0)+1);    
                
                if(h.size()==dist){
                    //aesa isliye kyunki agar r tak me hi sare doistinct aa jarahe to aage wale me v max utne hi aenge to sako ek hi baar me count kar le rahe hain
                    count+=(n-r);
                    break;
                }
                f1=true;
                
            }
            while(l<r){
                l++;
                h.put(arr[l],h.get(arr[l])-1);
                if(h.get(arr[l])==0) {
                    h.remove(arr[l]);
                }
                if(h.size()==dist){
                    count+=n-r;
                    
                }else if(h.size()<dist){
                    break;
                }
                f2=true;
            }
            if(f1==false && f2==false) break;
        }
        return count;
    }
}


//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		// looping through all testcases
		while(testcases-- > 0){
		    int n=Integer.parseInt(br.readLine());
		    String line1 = br.readLine();
		    String[] a1 = line1.trim().split("\\s+");
		    int a[]=new int[n];
		    for(int i=0;i<n;i++)
		    {
		        a[i]=Integer.parseInt(a1[i]);
		    }
		    Solution ob=new Solution();
		    int ans=ob.countDistinctSubarray(a,n);
		    System.out.println(ans);
		    
		}
	}
}

// } Driver Code Ends