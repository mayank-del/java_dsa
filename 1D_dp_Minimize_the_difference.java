//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int k;
            k = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.minimizeDifference(n, k, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int minimizeDifference(int n, int k, int[] arr) {
        // code here
        
        int rmax[]=new int[n];
        int rmin[]=new int[n];
        
        int lmax[]=new int[n];
        int lmin[]=new int[n];
        
        int lptr=0,rptr=0;
        
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for (int i=0;i<n;i++){
            max=Math.max(max,arr[i]);
            min=Math.min(min,arr[i]);
            
            rmax[i]=max;
            rmin[i]=min;
            
            
        }
        
        
        max=Integer.MIN_VALUE;
        min=Integer.MAX_VALUE;
        
        int ans=Integer.MAX_VALUE;
        
        for (int i=n-1;i>=0;i--){
            max=Math.max(max,arr[i]);
            min=Math.min(min,arr[i]);
            
            lmax[i]=max;
            lmin[i]=min;
            
            
        }
        max=lmax[k];
        min=lmin[k];
        
        ans=max-min;
        
        max=Integer.MIN_VALUE;
        min=Integer.MAX_VALUE;
        
        for(int i=k+1;i<n;i++){
            max=Math.max(lmax[i],rmax[lptr]);
            min=Math.min(lmin[i],rmin[lptr]);
            
            ans=Math.min(ans,max-min);
            
            lptr++;
        }
        ans=Math.min(ans,rmax[n-k-1]-rmin[n-k-1]);
        return ans;
    }
}
        
