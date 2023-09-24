//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            int K = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.countOfSubstrings(S,K));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int countOfSubstrings(String s, int k) {
        // code here
        int left=0;
        int right=0;
        int count=0;
        int n=s.length();
        int cnt=0;
        //Queue<Integer> q=new LinkedList<>();
        HashMap<Character,Integer> h=new HashMap<>();
        for(;right<n;){
            if(right<k){
                h.put(s.charAt(right),h.getOrDefault(s.charAt(right),0)+1);
                //q.add(s.charAt(right));
                right++;
                if(right==k && h.size()==k-1){
                    count++;
                }
            }else if(right>=k){
                
                h.put(s.charAt(right),h.getOrDefault(s.charAt(right),0)+1);
                h.put(s.charAt(left),h.get(s.charAt(left))-1);
                //h.compute(s.charAt(left), (key, value) -> value - 1);
                if(h.get(s.charAt(left))==0) h.remove(s.charAt(left));
                if(h.size()==k-1){
                    count++;
                }
                right++;
                left++;
            }
        }
        return count;
    }
};