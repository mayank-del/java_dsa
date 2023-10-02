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
        int len=-1;
        int r=-1;
        int l=-1;
        HashMap<Character,Integer> h=new HashMap<>();
        while(true){
            //acquire
            boolean f1=false;
            boolean f2=false;
            while(r<s.length()-1){
                f1=true;
                r++;
                char ch=s.charAt(r);
                h.put(ch,h.getOrDefault(ch,0)+1);
                if(h.size()>k){
                    break;
                }else if(h.size()==k){
                    len=Math.max(len,r-l);
                }
            }

            //release
            while(l<r){
                f2=true;
                l++;
                char ch=s.charAt(l);
                h.put(ch,h.get(ch)-1);
                if(h.get(ch)==0) {
                    h.remove(ch);
                }
                if(h.size()==k){
                    break;
                }
            }

            if(f1==false && f2==false) break;
        }


        return len;

    }
}

