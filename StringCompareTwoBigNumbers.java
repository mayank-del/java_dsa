//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String a = sc.next ();
            String b = sc.next();
            Solution obj = new Solution();
    		System.out.println (obj.check (a, b));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    int check (String a, String b)
    {
        // your code here
        int i=0;
        while(i<a.length() && a.charAt(i)=='0'){
            i++;
        }
        a=a.substring(i);
        i=0;
        while(i<b.length() && b.charAt(i)=='0'){
            i++;
        }
        b=b.substring(i);
        
        if(a.length()>b.length()) return 2;
        else if(a.length()<b.length()) return 1;
        
        else if(a.length()==b.length()){
            i=0;
            int n=a.length();
            while(i<n){
                if(a.charAt(i)>b.charAt(i)){
                    return 2;
                }else if(a.charAt(i)<b.charAt(i)){
                    return 1;
                }else{
                    i++;
                }
            }
        }
        return 3;
    }
}