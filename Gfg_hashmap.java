//{ Driver Code Starts
import java.util.*;
import java.io.*;
public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0){
            ot.println(new Solution().CountStrings(br.readLine().trim()));
        }
        ot.close();
    }
} 
// } Driver Code Ends


class Solution{
    public int CountStrings(String s){
        // Code Here.
        int arr[]=new int[1];
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                f(s.substring(i,j),arr);
            }
        }
        
        return arr[0];
        
    }
    
    void f(String s,int arr[]){
        int max1=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            max1=Math.max(max1,Integer.parseInt(s.charAt(i)+""));
        }
        HashMap<Character,Integer> h=new HashMap<>();
        for(int i=0;i<s.length();i++){
            h.put(s.charAt(i),h.getOrDefault(s.charAt(i),0)+1);
            if(h.get(s.charAt(i))>=max1){
                return ;
            }
        }
        arr[0]++;
        return;
    }
}