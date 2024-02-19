//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minValue(s, k));
        }
    }
}
// } Driver Code Ends

class Pair{
    int ch;
    int freq;
    Pair(int ch,int freq){
        this.ch=ch;
        this.freq=freq;
    }
}

class Solution{
    static int minValue(String s, int k){
        // code here
        HashMap<Character,Integer> h=new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.freq-a.freq);
        
        int ans=0;
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            h.put(ch,h.getOrDefault(ch,0)+1);
            
        }
        
        for(Character ch:h.keySet()){
            pq.add(new Pair(ch,h.get(ch)));
            
        }
            
        
        while(k!=0){
            Pair p=pq.remove();
            
            int new_freq_val=p.freq-1;
            pq.add(new Pair(p.ch,new_freq_val));
            k--;
        }
        int sum=0;
        while(!pq.isEmpty()){
            Pair p=pq.remove();
            sum+=(p.freq*p.freq);
        }
        
        return sum;
    }
}