//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        while(t > 0)
        {
            int n = in.nextInt();
            Geeks obj = new Geeks();
            System.out.println(obj.count(n));
            t--;
        }
    }
}
// } Driver Code Ends


// Complete this function!

class Geeks {
    public long count(int n) {
        // Add your code here.
        int arr[]={3,5,10};        
        //int res[]=new int [1];
        int dp[][]=new int[3][n+1];
        for(int i=0;i<3;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;
            }
        }
        return f(2,n,dp,arr);
    }
    int f(int ind,int n, int dp[][],int arr[]){
        if(ind==0){
            if(n%arr[ind]==0) return 1;
            else return 0;
        }
        
        if(dp[ind][n]!=-1) return dp[ind][n];
        //int pick1=f(ind-1,n-arr[ind],res,arr);
        int not_pick=f(ind-1,n,dp,arr);
        
        int pick=0;
        if(arr[ind]<=n)
            pick=f(ind,n-arr[ind],dp,arr);
        
        
        return dp[ind][n]=pick+not_pick;
        
        
        
    }
}