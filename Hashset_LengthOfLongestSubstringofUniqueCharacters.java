//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    int longestUniqueSubsttr(String s){
        
        int right=0;
        int left=0;
        int n=s.length();
        int count=0;
        HashSet<Character> h=new HashSet<>();
        for(;right<n;){
            if(!h.contains(s.charAt(right))){
                h.add(s.charAt(right));
                count=Math.max(count,h.size());
                right++;
            }else{
                while(s.charAt(left)!=s.charAt(right)){
                    h.remove(s.charAt(left));
                    left++;
                }
                h.remove(s.charAt(left));
                left++;
                //h.clear();
            }
        }
        return count;
    }
}