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
            
            
            int[] nums = IntArray.input(br, n);
            
            
            int k;
            k = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.longestOnes(n, nums, k);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int longestOnes(int n, int[] nums, int k) {
        // code here
        int zero=0;
        int l=-1;
        int r=-1;
        int maxm=0;
        while(true){
            boolean f1=false, f2=false;
            while(r<n-1){
                f1=true;
                r++;
                if(nums[r]==0){
                    zero++;
                }
                if(zero==k){
                    maxm=Math.max(maxm,r-l);
                }
                else if(zero>k){
                    break;
                }
                maxm=Math.max(maxm,r-l);
            }
            while(l<r){
                f2=true;
                l++;
                if(nums[l]==0){
                    zero--;
                }if(zero==k){
                    break;
                }
            }
            
            if(f1==false && f2 ==false) break;
            
        }
        
        return maxm;
    }
}
        
