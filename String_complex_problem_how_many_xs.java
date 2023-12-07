//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int L = Integer.parseInt(S[0]);
            int R = Integer.parseInt(S[1]);
            int X = Integer.parseInt(S[2]);
            Solution ob = new Solution();
            System.out.println(ob.countX(L, R, X));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int countX(int L, int R, int X) {
        int cnt=0;
        
        String str=X+"";
        char ch=str.charAt(0);
        for(int i=L+1;i<R;i++){
            String s= Integer.toString(i);
            if(s.contains(str)){
                for(int j=0;j<s.length();j++){
                    if(s.charAt(j)==ch){
                        cnt++;
                    }
                }
                
            }
        }
        return cnt;
    }
};