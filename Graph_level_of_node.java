//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int X = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.nodeLevel(V,list,X));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution
{
    //Function to find the level of node X.
    int lvl=0;
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
        Queue<Integer> q = new LinkedList<>();
        //ArrayList<Integer> res = new ArrayList<>();
   // ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    
    boolean vis[] = new boolean[V];


    vis[0] = true;
    q.add(0);

    while (!q.isEmpty()) {
        int n=q.size();
        
        for(int i=0;i<n;i++){
            int node=q.remove();
            if(node==X) return lvl;
            for (Integer it : adj.get(node)) {
                if (!vis[it]) {
                    q.add(it);
                    vis[it] = true;
                }
            }
    }
    
        lvl++;
        }
        return -1;
    }   
}