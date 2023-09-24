//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[][] Intervals = new int[n][2];
            int j = 0;
            for(int i = 0; i < n; i++){
                Intervals[i][0] = Integer.parseInt(s[j]);
                j++;
                Intervals[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            int[][] ans = obj.overlappedInterval(Intervals);
            for(int i = 0; i < ans.length; i++){
                for(j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int[][] overlappedInterval(int[][] arr)
    {
        // Code here // Code here
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        
        adj.add(new ArrayList<>(Arrays.asList(arr[0][0],arr[0][1])));
        
        for(int i=1;i<arr.length;i++){
            //case 1 andar sama jaye
            if(arr[i][1]<=adj.get(adj.size()-1).get(1))
                continue;
            //case 2 right side se bahara nikal jaye
            
            else if(arr[i][0] <= adj.get(adj.size()-1).get(1))
                //persist the left side , it will be same, it will not change
                {
                int leftSide=adj.get(adj.size()-1).get(0);
                adj.remove(adj.size()-1);
                adj.add(new ArrayList<>(Arrays.asList(leftSide,arr[i][1])));
                    
                }
            //case 3 right side se next interval me chala jaega
            else
                //directly adding
                {
                adj.add(new ArrayList<>(Arrays.asList(arr[i][0],arr[i][1]))); 
                }
            
        }
        int a[][]=new int[adj.size()][2];
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<2;j++){
                a[i][j]=adj.get(i).get(j);
            }
        }
        return a;
    }
}