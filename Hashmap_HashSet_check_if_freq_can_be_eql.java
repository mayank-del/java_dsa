//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            
            Solution ob = new Solution();
            if(ob.sameFreq(a)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    boolean sameFreq(String s) {
        // code here
        
        HashSet<Integer> set=new HashSet<>();
        HashMap<Character,Integer> h=new HashMap<>();
        int minm=10000000;
        for(Character ch:s.toCharArray()){
            h.put(ch,h.getOrDefault(ch,0)+1);
            
        }
        if(h.size()==1)return true;
        for(Character ch:h.keySet()){
            set.add(h.get(ch));
            minm=Math.min(minm,h.get(ch));
        }
        if(set.size()==1)return true;
        if(set.size()==2 && set.contains(1)) return true;
        int cnt=0;
        for(Character ch:h.keySet()){
            /*if(set.contains(h.get(ch))){
                continue;
            }else if(!set.contains(h.get(ch)) && set.size()<=1){
                set.add(h.get(ch));
            }else{
                return false;
            }*/
            int diff=h.get(ch)-minm;
            if(diff==1)cnt++;
            else if(diff>1)return false;
            if(cnt>1)return false;
        }
        return true;
    }
}