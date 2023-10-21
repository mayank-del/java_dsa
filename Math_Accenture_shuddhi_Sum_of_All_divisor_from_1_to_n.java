//recursion

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
            int N=sc.nextInt();
            Solution ob = new Solution();
            long ans  = ob.sumOfDivisors(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static long sumOfDivisors(int N){
        // code here
        
        return f(N,1);
        
    }
    static long f(int n, int ind){
        if(ind==n){
            long s=0;
            for(int i=1;i<=n;i++){
                if(n%i==0)
                    s+=i;
            }
            return s;
        }
        
        long sum=0;
        for(int i=1;i<=ind;i++){
            if(ind%i==0)
                sum+=i;
        }
        return sum+f(n,ind+1);
    }
}

//Simple approach

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
            int N=sc.nextInt();
            Solution ob = new Solution();
            long ans  = ob.sumOfDivisors(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static long sumOfDivisors(int N){
        // code here
        long res=0;
        for(int i=1;i<=N;i++){
            int no_of_times_i_appered=N/i;
            res+=(i*no_of_times_i_appered);
        }
        
        return res;
    }
    
}