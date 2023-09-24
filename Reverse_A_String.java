//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- >0)
        {
            String str = read.readLine();
            System.out.println(new Reverse().reverseWord(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Reverse
{
    // Complete the function
    // str: input string
    public static String reverseWord(String str)
    {
        // Reverse the string str
        char ch[]=str.toCharArray();
        int left=0;
        int right=ch.length-1;
        for(;left<right;){
            char temp=ch[right];
            ch[right]=ch[left];
            ch[left]=temp;
            right--;
            left++;
        }
        
        String res=new String(ch);
        
        return  res;
    }
}