//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());//testcases
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(reader.readLine());//input n
            //printing "1" if isLucky() returns true else "0"
            Solution s = new Solution();
            System.out.println(s.isLucky(n)? "1" : "0");
        }
    }
}
// } Driver Code Ends


//User function Template for Java



class Solution
{
    // Complete the function
    // n: Input n
    // Return True if the given number is a lucky number else return False
    public static boolean isLucky(int n)
    {
        // Your code here
        ArrayList<Integer> arr=new ArrayList<>();
        ArrayList<Integer> a=new ArrayList<>();
        //int ser1=1;
        for(int i=1;i<=n;i++){
            arr.add(i);
        }
        int diff=2;
        for(int i=0;i<arr.size();i++){
            a=new ArrayList<>();
            int it=-1;
            it=it+diff;
            for(int j=0;j<arr.size();j++){
                if(j==it){
                    it+=diff;
                    continue;
                }
                a.add(arr.get(j));
            }
            arr=a;
            diff++;
        }
        if(a.contains(n)) return true;
        else return false;
    }

/*     public static boolean isLucky(int n)
    {
        // Your code here
      int x=(int)Math.sqrt(n);
      int c=2;
      ArrayList<Integer> ans=new ArrayList<>();
       for(int i=1;i<=n;i++)
       {
           ans.add(i);
       }
       while(c<=ans.size())
       {
           for(int i=c-1;i<ans.size();i+=c-1){
           ans.remove(i);}
           if(!ans.contains(n))
           return false;
           c++;
       }
       if(ans.contains(n))
       return true;
       else
       return false;
        
    } */
}