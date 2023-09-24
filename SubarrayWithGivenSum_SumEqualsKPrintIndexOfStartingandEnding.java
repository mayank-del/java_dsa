//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(a, n, k);
            for(int ii = 0;ii<res.size();ii++)
                ot.print(res.get(ii) + " ");
            ot.println();
        }
        ot.close();
    }

}
// } Driver Code Ends


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
       
        
        ArrayList<Integer> adj= new ArrayList<>();
        
        for(int i=0;i<n;i++){
            if(arr[i]==s){
                adj.add(i+1);
                adj.add(i+1);
                return adj;
            }
        }
        
        if(s==0){
            adj.add(-1);
            return adj;
        }
        //Arrays.sort(arr);
        int sum=arr[0];
        
        int left=0;
        int right=0;
        
        
        
        for(;right<n;){
            if(sum==s){
                adj.add(left+1);
                adj.add(right+1);
                return adj;
            }
            
            else if(s<sum){
                
                sum-=arr[left];
                left++;
            }else if(s>sum ){
                right++;
                if(right<n)
                    sum+=arr[right];
            }
        }
        adj.add(-1);
        
        return adj;
    }
}