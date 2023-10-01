//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            
            Solution obj = new Solution();    
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);
            
           
        }
        
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        // add your code
        HashMap<String,Integer> h=new HashMap<>();
        
        for(int i=0;i<n;i++){
            h.put(arr[i],h.getOrDefault(arr[i],0)+1);
        }
        int maxm=0;
        String names[]=new String[2];
        for(String name:h.keySet()){
            if(h.get(name)>maxm){
                maxm=h.get(name);
                names[0]=name;
                names[1]=""+maxm;
            }else if(h.get(name)==maxm){
                if(name.compareTo(names[0])<0){
                    names[0]=name;
                }
            }
            
        }
        return names;
    }
}

