//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);

            int[] ans = new Solution().printKClosest(arr, n, k, x);
            for (int xx : ans) {
                System.out.print(xx + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Pair{
    int num;
    int diff;
    Pair(int num,int diff){
        this.num=num;
        this.diff=diff;
    }
}
// User function Template for Java

class Solution {
    int[] printKClosest(int[] arr, int n, int k, int x) {
        // code here
    int res[]=new int[k];
    // here we are sorting in two nested sorting criterias firt sorting will happen on term of 
    // absolute differences and second will happen in term of greatest number s.t 
    //greates nummber will come first 
    PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
        return a.diff-b.diff==0?b.num-a.num:a.diff-b.diff;
        
    });
    
    for(int it:arr){
        pq.add(new Pair(it,Math.abs(it-x)));
    }
    int cnt=0;
    for(int i=0;i<n;i++){
        if(!pq.isEmpty()){
            Pair p=pq.remove();
            
            if(p.diff!=0){
                res[cnt++]=p.num;
            }
            
            if(cnt==k)break;
        }
    }
    
    return res;
    }
}
