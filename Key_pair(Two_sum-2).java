//{ Driver Code Starts
//Initial Template for Java




import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            boolean ans = new Solution().hasArrayTwoCandidates(arr, n, x);
            System.out.println(ans ? "Yes" : "No");
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        // code here
        //HashSet<Integer>h=new HashSet<>();
        HashMap<Integer,Integer>h=new HashMap<>();
        for(int i=0;i<n;i++){
            h.put(arr[i],h.getOrDefault(arr[i],0)+1);
        }
        for(int i=0;i<n;i++){
            if(x-arr[i] !=arr[i] && h.containsKey(x-arr[i])){
                return true;
            }else if(x-arr[i] == arr[i] && h.containsKey(x-arr[i]) && (arr[i])*h.get(arr[i])==x){
                return true;
            }else if(x-arr[i] == arr[i] && h.containsKey(x-arr[i]) && (arr[i])*h.get(arr[i])!=x){
                break;
            }else {
                continue;
            } 
        }
        return false;
    }
}