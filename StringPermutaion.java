//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public ArrayList<String> permutation(String s)
    {
        //Your code here
        ArrayList<String> arr=new ArrayList<>();
        f(arr,0,s);
        int n=s.length();
        
        Collections.sort(arr);
        return arr;
    }
    public void f(ArrayList<String> arr,int ind,String s){
        if(ind==s.length()) {
            arr.add(s);
            return;
        }
        
        
        for(int i=ind;i<s.length();i++){
            
                char a[]=s.toCharArray();
                char temp=a[i];
                a[i]=a[ind];
                a[ind]=temp;
                s=new String(a);
                
                f(arr,ind+1,s);
                
                char b[]=s.toCharArray();
                char temp2=b[i];
                b[i]=b[ind];
                b[ind]=temp2;
                s=new String(b);
                
        }
    }
	   
}
