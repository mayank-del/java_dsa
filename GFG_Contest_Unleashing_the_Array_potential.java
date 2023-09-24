//{ Driver Code Starts
import java.util.*;
import java.io.*;
public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine().trim());
            String s[] = br.readLine().trim().split(" ");
            int arr[] = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(s[i]);
            
            long ans = new Solution().maxValue(n, arr);
            ot.println(ans);
        }
        ot.close();
    }
} 
// } Driver Code Ends


class Solution{
    public long maxValue(int n, int arr[]){
        // Code Here.
        int ind1=0;
        int ind2=0;
        int ind3=0;
        long max1=Long.MIN_VALUE;
        long max2=Long.MIN_VALUE;
        long max3=Long.MIN_VALUE;
        
        //left max
        long m1[]=new long[arr.length];
        //right max
        long m2[]=new long[arr.length];
        for(int i=0;i<n;i++){
            if(arr[i]>max1){
                max1=arr[i];
                m1[i]=max1;
            }
            else{
               m1[i]=max1; 
            }
            
        }
        for(int j=n-1;j>=0;j--){
            if(arr[j]>max2){
                max2=arr[j];
                m2[j]=max2;
            }
            else{
               m2[j]=max2; 
            }
            
        }
        for(int i=1;i<n-1;i++){
            max3=Math.max(max3,(long)((m1[i-1]-arr[i])*m2[i+1]));
        }
        
        return max3;
    }
}