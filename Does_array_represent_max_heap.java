//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.countSub(a, n) ? 1:0);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public boolean countSub(long arr[], long n)
    {
        // Your code goes here
        Queue<Integer> q=new LinkedList<>();
        int conv_ind=(int)n;
        int vis[]=new int[conv_ind];
        Arrays.fill(vis,0);
        
        q.add((int)arr[0]);
        boolean res=true;
        for(int i=0;i<conv_ind;i++){
            if(vis[i]!=1){
                int node=(int)arr[i];
                res=bfs(q,arr,vis,i,conv_ind);
                if(!res){
                    return false;
                }
            }
        }
        
        return res; 
    }
    
    public boolean bfs(Queue<Integer> q,long arr[],int vis[],int curr, int n){
            
            
            vis[curr]=1;
            
            while(!q.isEmpty()){
                
                int node=q.remove();
                
                int left_child_ind=(2*curr)+1;
                int right_child_ind=(2*curr)+2;
                int l_val=0,r_val=0;
                if(left_child_ind<n){
                    l_val=(int)arr[left_child_ind];
                }
                if(right_child_ind<n){
                    r_val=(int)arr[right_child_ind];
                }
                if(l_val>node || r_val>node){
                    return false;
                }
                if(l_val>0 && vis[left_child_ind]!=1){
                    q.add(l_val);
                    if(!bfs(q,arr,vis,left_child_ind,n)) return false;
                }
                
                if(r_val>0 && vis[right_child_ind]!=1){
                    q.add(r_val);
                    if(!bfs(q,arr,vis,right_child_ind,n)) return false;
                }
            }
            return true;
        }
}