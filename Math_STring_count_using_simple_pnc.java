//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  
        
        int t = Integer.parseInt(br.readLine().trim()); 

        while(t > 0){
        	long n = Integer.parseInt(br.readLine().trim()); 
            Solution ob = new Solution();
            System.out.println(ob.countStr(n)); 
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    static long countStr(long n)
	{
	    //six possible cases
	    
	    // all a
	    long first=1;
	    // 1 b, rest all a
	    long sec=n;
	    // 1 c, rest all a
	    long third=n;
	    //2 c, rest all a
	    long four=(n*(n-1))/2;
	    // 1 b, 1 c, rest all a
	    long fivth=(n*(n-1));
	    // 2 c, 1 b, rest all a 
	   long sixth=((n*(n-1))/2)*(n-2)*1;
	   
	   long tot=first+sec+third+four+fivth+sixth;
	   
	   return tot;
	}
} 