//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException {
		
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            
            int gallery[] = new int[n];
            for(int i=0; i<n; i++)
                gallery[i] = Integer.parseInt(s[i]);
            Solution T = new Solution();
            out.println(T.min_sprinklers(gallery,n));
        }
		out.close();
		
	}
}





// } Driver Code Ends


//User function Template for Java
class Ranges{
    int left;
    int right;
    Ranges(int left,int right){
        this.left=left;
        this.right=right;
    }
}


class Solution
{
    int min_sprinklers(int gallery[], int n)
    {
        // code here
        
        Ranges r[]=new Ranges[n];
        int minm=Integer.MAX_VALUE;
        
        for(int i=0;i<n;i++){
            r[i]=new Ranges(i-gallery[i],i+gallery[i]);
        }
        Arrays.sort(r,(a,b)->a.left-b.left);
        
        int ans=0,target=0,i=0;
        
        while(target<n){
            if(i==r.length || r[i].left>target){
                return -1;
            }
            int max_ran=r[i].right;
            
            while(i+1<r.length && r[i+1].left<=target){
                i++;
                max_ran=Math.max(max_ran,r[i].right);
            }
            if(max_ran<target){
                return -1;
            }
            ans++;
            target=max_ran+1;
            i++;
        }
        return ans;
    }
}
