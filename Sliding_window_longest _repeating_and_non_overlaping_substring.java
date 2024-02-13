//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestSubstring(S, N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static String longestSubstring(String s, int n) {
        // code here
        int l=-1,r=-1;
        int maxm=0;
        int start=0,end=0;
        while(true){
            boolean vis1=false,vis2=false;
            while(r<n-1){
                vis1=true;
                r++;
                if(s.substring(r).contains(s.substring(l+1,r))){
                    //maxm=Math.max(maxm,r-l);
                    if(r-l>maxm){
                        maxm=r-l;
                        start=l+1;
                        end=r;
                    }
                }
                else{
                    break;
                }
            }
            while(l<r){
                vis2=true;
                l++;
                break;
                
            }
            if(!vis1 && !vis2){
                break;
            }
        }
        if(s.substring(start,end).equals("")){
            return "-1";
        }
        return s.substring(start,end);
    }
};