//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int smallestSubstring(String S) {
        // Code here
        int n=S.length();
        
        HashMap<Character,Integer> h=new HashMap<>();
        int left=-1, right=-1;
        int size=-1;
        int res=Integer.MAX_VALUE;
        
        
        while(true){
            boolean fl=false,fl2=false;
            while(right<n-1){
                
                fl2=true;
                
                right++;
                char ch=S.charAt(right);
                
                h.put(ch,h.getOrDefault(ch,0)+1);
                if(h.size()==3){
                    res=Math.min(res,right-left);
                    break;
                }
                
            }
            
            while(left<right){
                
                fl=true;
                
                left++;
                char ch=S.charAt(left);
                
                h.put(ch,h.get(ch)-1);
                if(h.get(ch)==0){
                    h.remove(ch);
                    break;
                }
                if(h.size()==3){
                    res=Math.min(res,right-left);
                    //break;
                }else{
                    break;
                }
                
                
                
            }
            
            
            if(fl==false && fl2==false){
                break;
            }
        }
        if(res==Integer.MAX_VALUE) res=-1;
        return res;
    }
};
