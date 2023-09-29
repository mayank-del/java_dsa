//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int smallestSubstring(String S) {
        // Code here
        int arr[]=new int[3];
        
        int i=0,j=0;
        int minm=Integer.MAX_VALUE;
        while(i>=j ){
            if(arr[0]>=1 && arr[1]>=1 && arr[2]>=1){
                minm=Math.min(minm,i-j);
                int num=S.charAt(j)-'0';
                arr[num]--;
                j++;
            }else{
                if(i>=S.length()) break;
                int num=S.charAt(i)-'0';
                arr[num]++;
                i++;
            }
           
        }
        /*for(int i=0;i<S.length();i++){
            if(S.charAt(i)-'0'==0){
                c1++;
            }else if(S.charAt(i)-'0'==1){
                c2++;
            }else if(S.charAt(i)-'0'==2){
                c3++;
            }
            if(c1>=1 && c2>=1 && c3>=1){
                return i+1;
            }
        }*/
        if(minm==Integer.MAX_VALUE) return -1;
        return minm;
    }
};
