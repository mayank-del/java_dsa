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
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String s){
        // code here
        HashSet<Character> h=new HashSet<>();
        int i=0,j=0;
        int count=0,maxCount=0;
        for(;j<=i&&i<s.length();){
            if(h.contains(s.charAt(i))){
                maxCount=Math.max(count,maxCount);
                while(s.charAt(j)!=s.charAt(i)){
                    h.remove(s.charAt(j));
                    j++;
                }
                h.remove(s.charAt(j));
                j++;
                h.add(s.charAt(i));
                count=h.size();
               
            }else{
                h.add(s.charAt(i));
                count++;
                //count=Math.max(count,h.size());
                
            }
            i++;
        }
        maxCount=Math.max(count,maxCount);
        return maxCount;
    }
}