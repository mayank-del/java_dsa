//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int left=0;
        int right=0;
        int n=s.length();
        HashMap<Character,Integer> h=new HashMap<>();
        //int arr[]=new int[s.length()];
        int count=0,maxCount=0;
        
        for(;right<n;){
            //if(h.size()<k ||(h.size()==k && h.containsKey(s.charAt(right)))){
            if (h.size() < k || (h.size() == k && h.get(s.charAt(right)) != null)) {
                
                //h.put(s.charAt(right),h.getOrDefault(s.charAt(right),0)+1);
                h.compute(s.charAt(right), (key, value) -> value == null ? 1 : value + 1);
                right++;
                count=right-left;
            }else if(h.size()==k && h.get(s.charAt(right))==null){
                //h.put(s.charAt(left),h.getOrDefault(s.charAt(left),0)-1);
                h.compute(s.charAt(left), (key, value) -> value - 1);
                if(h.get(s.charAt(left))==0){
                    h.remove(s.charAt(left));
                }
                left++;
                
            }
            if(h.size()==k){
                maxCount=Math.max(count,maxCount);
            }
        }
        if(maxCount==0) maxCount=-1;
        return maxCount;
    }
}