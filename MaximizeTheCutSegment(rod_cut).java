//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading length of line segment
            int n = Integer.parseInt(read.readLine().trim());
            
            
            //reading 3 segment lengths
            String str[] = read.readLine().trim().split(" ");
            
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int z = Integer.parseInt(str[2]);
            
            
            //calling method maximizeCuts() of class Solution()
            //and printinting the result
            System.out.println(new Solution().maximizeCuts(n, x, y, z));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    // Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z) {
        int ind = 2;
        int arr[] = {x, y, z};
        int ans=f(n, arr, ind);
        if(ans<0) return 0;
        else return ans;
    }

    int f(int n, int arr[], int ind) {
        if (n == 0)
            return 0;
        if (ind == 0) {
            if (n % arr[ind] == 0)
                return n / arr[ind]; // Return the number of cuts
            else
                return Integer.MIN_VALUE; // Indicate no valid cuts can be made
        }

        // Base case for handling negative values of n.
        if (n < 0) {
            return Integer.MIN_VALUE;
        }

        int notTake = f(n, arr, ind - 1); // Decrease 'ind' here to prevent infinite loop
        int take = Integer.MIN_VALUE;
        if (n >= arr[ind])
            take = 1 + f(n - arr[ind], arr, ind);

        return Math.max(take, notTake);
    }
}
