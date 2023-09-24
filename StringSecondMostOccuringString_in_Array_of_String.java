//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            for(int i = 0;i<n;i++)
                arr[i] = sc.next();
            
            Solution ob = new Solution();
            
            System.out.println(ob.secFrequent(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    String secFrequent(String arr[], int N)
    {
        // your code here
        HashMap<String,Integer>h =new HashMap<>();
        ArrayList<Integer> a=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            h.put(arr[i],h.getOrDefault(arr[i],0)+1);
        }
        int max=0;
        String res="";
        for(String s:h.keySet()){
            //a.add(h.get(s));
            if(h.get(s)>max){
                max=h.get(s);
            }
        }
        int sec=0;
        
        for(String s:h.keySet()){
            //a.add(h.get(s));
            if(h.get(s)<max && h.get(s)>sec){
                res="";
                sec=h.get(s);
                res+=s;
            }
        }
        return res;
        
    }
}