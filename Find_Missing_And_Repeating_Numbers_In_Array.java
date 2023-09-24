//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        //Arrays.sort(arr);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(Integer it:arr){
            map.put(it,map.getOrDefault(it,0)+1);
            //map.compute(it, (key, value) -> value == null ? 1 : value + 1);
        }
        int res[]=new int[2];
        
        int repeat=0;
        int missed=0;
        
        for(int i=1;i<=n;i++){
            if(map.containsKey(i) && map.get(i)>=2){
                repeat=i;
            }else if(!map.containsKey(i)){
                missed=i;
            }
        }
        res[0]=repeat;
        res[1]=missed;
        return res;
    }
}