//{ Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        // code here
        if(arr.length==1) return arr[0];
        long max=Long.MIN_VALUE;
        for(int i=0;i<n-1;i++){
            long prod=arr[i];
            max=Math.max(max,prod);
            for(int j=i+1;j<n;j++){
                prod*=arr[j];
                max=Math.max(max,prod);
            }
        }
        max=Math.max(max,arr[n-1]);
        return max;
    }
}