//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            
            Solution ob = new Solution();
            int result = ob.isSame(s);
            
            System.out.println(result);
        }
    }
}
// } Driver Code Ends


//User function Template for Java
//import java.math.BigInteger;
class Solution {
    int isSame(String s) {
        int j = s.length() - 1;
        int n = j;
        
        // Find the last character that is a digit
        while (j >= 0 && (s.charAt(j) >= '0' && s.charAt(j) <= '9')) {
            j--;
        }
    
        // If j went below 0, it means there are no digits at the end of the string
        if (j < 0) {
            return 0; // No valid number
        }
    
        int num = 0;
        
        // Handle NumberFormatException by using a try-catch block
        try {
            num = Integer.parseInt(s.substring(j + 1, n + 1));
        } catch (NumberFormatException e) {
            return 0; // Failed to parse the number
        }
        
        int len = j + 1;
    
        if (len == num) {
            return 1;
        } else {
            return 0;
        }
    }

}