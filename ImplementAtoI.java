//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			int num = obj.atoi(str);
			
			System.out.println(num);
		t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String str) {
	// Your code here
	int n=str.length();
	int i=n-1;
	int places=1;
	int sum=0;
	boolean negative=false;
	while(i>=0){
	    if(negative) return -1;
	    int ind=str.charAt(i)-'0';
	    
	    //for -ve sign
	    if(ind==-3){ 
	        if(negative){
	            return -1;
	        }
	       negative=true;
	       i--;
	       continue; 
	    }
	    
	    //for any other character except -ve sign and digits
	    if(ind>9 || ind<0) return -1;
	    
	    sum+=places*(ind);
	    places*=10;
	    i--;
	}
	if(negative) return (-1*sum) ;
	return sum;
    }
}
