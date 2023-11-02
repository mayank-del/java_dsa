//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N = sc.nextInt();
            int K = sc.nextInt();
           
            Solution ob = new Solution();
            int ans = ob.setKthBit(N,K);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static int setKthBit(int N,int K){
        // code here
        //if u have to set a bit in 1010 just generate a number 0100 and do bitwise or
        //to genearte number llike this take 0001 and left shift opertor to 0001 by k ->0100
        
        int kth=1<<K;
        int res= N | kth;
        return res;
    }
}