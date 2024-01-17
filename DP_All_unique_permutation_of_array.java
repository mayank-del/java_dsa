//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            ArrayList<Integer> arr = new ArrayList<>();
            
            for(int i=0; i<n; i++)
                arr.add(Integer.parseInt(S[i]));

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> res = ob.uniquePerms(arr,n);
            for(int i=0; i<res.size(); i++)
            {
                for(int j=0; j<n; j++)
                {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    /*static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        // code here
        LinkedHashSet<ArrayList<Integer>> h=new LinkedHashSet<>();
        Collections.sort(arr);
        for(int i=0;i<n;i++){
            ArrayList<Integer> copy = new ArrayList<>(arr);
            h.add(copy);

            // Perform the rotation for the next permutation
            int first = arr.get(0);
            arr.remove(0);
            arr.add(first);
            
        }
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        
        for(ArrayList<Integer> list : h){
            res.add(list);
        }
        
        return res;
    }*/
        static void help(ArrayList<Integer> arr,int n,HashSet<ArrayList<Integer>> mm,int index){
          if(index==n){
              ArrayList<Integer> nn = new ArrayList<>(arr);
              mm.add(nn);
              return;
          }
      for(int i=index;i<n;i++){
          int a = arr.get(i);
          int b = arr.get(index);
          arr.set(i,b);
          arr.set(index,a);
          help(arr,n,mm,index+1);
          arr.set(i,a);
          arr.set(index,b);
      }
    }
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        HashSet<ArrayList<Integer>> mm = new HashSet<>();
        help(arr,n,mm,0);
        for(ArrayList<Integer> temp:mm)ans.add(temp);
        Collections.sort(ans, new Comparator<List<Integer>>() {
            public int compare(List<Integer> a, List<Integer> b) {
                int i = 0;
                while(i<n) {
                    if(a.get(i).compareTo(b.get(i)) != 0)
                        return a.get(i).compareTo(b.get(i));
                    i++;
                }
                return 0;
            }
        });
        return ans;
    }
};