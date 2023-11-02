//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = Integer.parseInt(str[i]);
            String[] xy = br.readLine().trim().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            Solution g = new Solution();
            System.out.println(g.minDist(a, n, x, y));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int minDist(int a[], int n, int x, int y) {
        // code here
        int xval=0;
        int yval=0;
        int xind=-1,yind=-1;
        int diff=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(a[i]==x){
                xval++;
                yval=0;
                xind=i;
            }
            if(a[i]==y){
                yval++;
                xval=0;
                yind=i;
            }
            if((xval==0 && yval==1 && xind!=-1 && yind!=-1 ) || (xval==1 && yval==0 && xind!=-1 && yind!=-1 ))
                diff=Math.min(diff,Math.abs(xind-yind));
                
            
            
        }
        if(diff==Integer.MAX_VALUE){
            diff=-1;
        }
        return diff;
    }
}