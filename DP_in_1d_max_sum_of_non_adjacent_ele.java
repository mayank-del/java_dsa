//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int findMaxSum(int arr[], int n) {
        //code here
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return f(0,arr,n,dp);
    }
    
    int f(int ind, int arr[], int n, int dp[]){
        
        if(ind>=n) return 0;
        
        if(dp[ind]!=-1) return  dp[ind];
        int pick=arr[ind]+f(ind+2,arr,n,dp);
        int notPick=f(ind+1,arr,n,dp);
        
        return dp[ind]=Math.max(pick,notPick);
    }
}