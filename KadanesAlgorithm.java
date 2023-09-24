//{ Driver Code Starts
import java.io.*;

import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling maxSubarraySum() function
		    System.out.println(obj.maxSubarraySum(arr, n));
		}
	}
}


// } Driver Code Ends


class Solution{

    // arr: input array
    // n: size of array
    //Function to find the sum of contiguous subarray with maximum sum.
    long maxSubarraySum(int arr[], int n){
        
        // Your code here
        //it says that , you will start taking sum of all element inside  anarray , but whenever u ll see the sum as -ve  value  , u have make ur entire sum 0 , bcoz in future u wiill expect atleast +ve sum 
        long sum=0,max=0;
        
        
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum<0){ 
                sum=0;
            }
            max=Math.max(max,sum);
        }
        
        if(max==0){
            max=Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                if(arr[i]>max ){
                    max=arr[i];
                }
            }
        }
        
        return max;
    }
    
}

