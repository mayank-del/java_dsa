//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        int count=0;
        for(int i=0;i<n;i++){
            if(arr[i]==x){
                count++;
            }
        }
        return count;
    }
       /* int left_ind=lbs(arr,0,n-1,x);
        int right_ind=rbs(arr,0,n-1,x);
        
        return right_ind-left_ind;
    }
    
    int lbs(int arr[], int l, int r, int x){
        while(l<=r){
            int mid=(l+r)/2;
            
            if(arr[mid]>=x) r=mid-1;
            else l=mid+1;
            
            
        }
        
        return r;
    }
    
    int rbs(int arr[], int l, int r, int x){
        while(l<=r){
            int mid=(l+r)/2;
            
            if(arr[mid]<=x) l=mid+1;
            else r=mid-1;
            
            
        }
        
        return r;
    }*/
    
}