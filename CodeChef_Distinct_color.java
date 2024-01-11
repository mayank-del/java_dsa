import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		while(T>0){
		    int n=sc.nextInt();
		    int nums[]=new int[n];
		    for(int i=0;i<n;i++){
		        nums[i]=sc.nextInt();
		    }
		    int maxm= Arrays.stream(nums).max().getAsInt(); 
		    System.out.println(maxm);
		    T--;
		}

	}
}
