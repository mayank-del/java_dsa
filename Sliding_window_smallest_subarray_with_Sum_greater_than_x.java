//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            // int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.smallestSubWithSum(a, n, m));
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {

    public static int smallestSubWithSum(int a[], int n, int x) {
        // Your code goes here
        int l = -1,r = -1;
        int sum=0;
        int len=Integer.MAX_VALUE;
        
        while(true){
            boolean loop1=false, loop2=false;
            while(r<a.length-1){
                loop1=true;
                r++;
                sum+=a[r];
                if(sum>x){
                   len=Math.min(len,r-l);
                   break;
                }
            }while(l<r){
                loop2=true;
                l++;
                sum-=a[l];
                if(sum>x){
                   len=Math.min(len,r-l); 
                }else{
                    break;
                }
            }
            if(loop1==false && loop2==false) break;
        }
        if(len==Integer.MAX_VALUE) return 0;
        return len;
    }
}

