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
            String S=read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.ExtractNumber(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    long ExtractNumber(String S){
        //code here
        long max=-1;
        String arr[]=S.split(" ");
        for(int i=0;i<arr.length;i++){
            if( arr[i].charAt(0)>=48 && arr[i].charAt(0)<57 ){
                int it=0;
                boolean found=false;
                while(it<arr[i].length()){
                    if(arr[i].charAt(it)==57){
                        found=true;
                        break;
                    }
                    it++;
                }
                if(found) continue;
                max=Math.max(Long.parseLong(arr[i]),max);
            }
            
        }
        return max;
    }
}