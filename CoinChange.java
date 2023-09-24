//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int coins[], int N, int sum) {
        // code here.
        long dp[][]=new long[N][sum+1];
        for(int i=0;i<N;i++){
            for(int j=0;j<sum+1;j++){
                dp[i][j]=-1;
            }
        }
        return f(coins,N-1,sum,dp);
    }
    long f(int coins[], int ind, int sum, long dp[][]){
        if(ind==0){
            if(sum%coins[0]==0)   
            //same as sum of ele eql to target  but there we have to take two base cases here it managed it within one by taking % instead of == operator
                return 1;
            else
                return 0;
        }
        if(dp[ind][sum]!=-1) return dp[ind][sum];
        
        long take=0;
        if(sum-coins[ind]>=0){
            take= f(coins,ind,sum-coins[ind],dp);
        }
        long notTake=f(coins,ind-1,sum,dp);
        return dp[ind][sum] = take + notTake;
    }   
}