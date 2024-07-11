import java.util.*;
import java.io.*;
//recursion
public class Solution {
    public static int findWays(int num[], int tar) {
        // Write your code here.
        int n=num.length;
        return f(num,0,tar,n);
    }

    public static int f(int num[],int ind,int tar,int n){
        if(tar==0){
            return 1;
        }
        if(ind==n-1){
           return (tar==num[ind])?1:0;
        }
        

        int notTake=f(num,ind+1,tar,n);
        int take=0;
        if(num[ind]<=tar){
            take=f(num,ind+1,tar-num[ind],n);
        }

        return take+notTake; 
        
    }
}


//memoisation

/* 
public class Solution {
    public static int findWays(int num[], int tar) {
        // Write your code here.
        int n=num.length;
        int dp[][]=new int[n][tar+1];

        for(int i=0;i<n;i++){
            for(int j=0;j<=tar;j++){
                dp[i][j]=-1;
            }
        }

        return f(num,0,tar,n,dp);
    }

    public static int f(int num[],int ind,int tar,int n,int dp[][]){
        if(tar==0){
            return 1;
        }
        if(ind==n-1){
           return (tar==num[n-1])?1:0;
        }
        if(dp[ind][tar]!=-1)return dp[ind][tar];
        

        int notTake=f(num,ind+1,tar,n,dp);
        int take=0;
        if(num[ind]<=tar){
            take=f(num,ind+1,tar-num[ind],n,dp);
        }

        return dp[ind][tar]=take+notTake; 
        
    }
}

 */