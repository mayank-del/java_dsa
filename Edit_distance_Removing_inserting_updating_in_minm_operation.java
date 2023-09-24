//to make two string eal we can do  insert , delete , update operation


//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int editDistance(String s, String t) {
        // Code here
        int dp[][]=new int[s.length()][t.length()];
        for(int i=0;i<s.length();i++){
            for(int j=0;j<t.length();j++){
                dp[i][j]=-1;
            }
        }
        return f(s,s.length()-1,t,t.length()-1,dp);
    }
    
    public int f(String s, int ind, String t, int ind2,int dp[][]){
        if(ind<0){
            return ind2+1;
        }if(ind2<0){
            return ind+1;
        }
        if(dp[ind][ind2]!=-1) return dp[ind][ind2];
        
        if(s.charAt(ind)==t.charAt(ind2)){
            return dp[ind][ind2] = 0 + f(s,ind-1,t,ind2-1,dp);
        }
                        //insert                    //delete              //update
        return dp[ind][ind2] = Math.min(1+f(s,ind,t,ind2-1,dp),Math.min(1+f(s,ind-1,t,ind2,dp),1+f(s,ind-1,t,ind2-1,dp)));
    }
}