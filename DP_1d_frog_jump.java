import java.util.* ;
import java.io.*; 
public class Solution {
    public static int frogJump(int n, int heights[]) {

        // Write your code here..
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        int res=f(heights,0,n,dp);
        return res;
    }
    public static int f(int hs[],int ind,int n,int dp[]){
        if(ind>=n-1){
            return 0;
        }
        if(dp[ind]!=-1){
            return dp[ind];
        }
        int fir=Math.abs(hs[ind+1]-hs[ind])+f(hs,ind+1,n,dp);
        int sec=Integer.MAX_VALUE;
        if(ind<n-2)
            sec=Math.abs(hs[ind+2]-hs[ind])+f(hs,ind+2,n,dp);

        return dp[ind]= Math.min(fir,sec);
    }

}