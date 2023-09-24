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
            
            String input[] = read.readLine().split(" ");
            String x = input[0];
            String y = input[1];
            Solution ob = new Solution();
            System.out.println(ob.search(x, y));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int search(String X, String Y) {
        // code here
        int i=0;
        int found=-1;
        for(;X.length()>=Y.length() && i<=X.length()-Y.length();){
            if(X.charAt(i)==Y.charAt(0) && X.substring(i,i+Y.length()).equals(Y)){
                found=i+1;
            }
            i++;
        }
        
        return found;
    }
}