import java.util.* ;
import java.io.*; 

/* Recursion */

public class Solution 
{
    public static int getLengthOfLCS(String  str1, String  str2)
    {
        // Write your code here.
        int n=str1.length();
        int m=str2.length();
        
        return f(str1,n-1,str2,m-1);

    }
    static int f(String str1,int ind1,String str2,int ind2){
        if(ind1<0 || ind2<0){
            return 0;
        }
        if(str1.charAt(ind1)==str2.charAt(ind2)){
            return 1+f(str1,ind1-1,str2,ind2-1);
        }else{
            return Math.max(f(str1,ind1,str2,ind2-1),f(str1,ind1-1,str2,ind2));
        }
    }
}

/* Memoisation */

import java.util.* ;
import java.io.*; 
public class Solution 
{
    public static int getLengthOfLCS(String  str1, String  str2)
    {
        // Write your code here.
        int n=str1.length();
        int m=str2.length();
        int dp[][]=new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }

        return f(str1,n-1,str2,m-1,dp);

    }
    static int f(String str1,int ind1,String str2,int ind2,int dp[][]){
        if(ind1<0 || ind2<0){
            return 0;
        }
        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
        if(str1.charAt(ind1)==str2.charAt(ind2)){
            return dp[ind1][ind2]= 1+f(str1,ind1-1,str2,ind2-1,dp);
        }else{
            return dp[ind1][ind2]= Math.max(f(str1,ind1,str2,ind2-1,dp),f(str1,ind1-1,str2,ind2,dp));
        }
    }
}