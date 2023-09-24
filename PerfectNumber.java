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
            long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.isPerfectNumber(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {

    /* 
    static int isPerfectNumber(long N) {
        // code here
        int sum=0;
        int num=1;
        for(;num<=N/2;){
            if(N%num==0){
                sum+=num;
            }
            num++;
        }
        if(sum==N) return 1;
        else return 0;
    }
     */

    static int isPerfectNumber(long N) {
        // code here
        if (N <= 1) {
        return 0;
    }

    long sum = 1; 
    long sqrtN = (long) Math.sqrt(N);

    for (long num = 2; num <= sqrtN; num++) {
        if (N % num == 0) {
            sum += num;
            if (num != N / num) {
                sum += N / num;
            }
        }
    }

    return (sum == N) ? 1 : 0;
    }



};