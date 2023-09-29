//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
          
            String S = read.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.removeReverse(S); 
            System.out.println(ans);
        }
    } 
} 

// } Driver Code Ends
//User function Template for Java

class Solution 
{ 
    String removeReverse(String S) 
    { 
        // code here
        
        StringBuffer s = new StringBuffer(S);
        int freq[] = new int[26];
        Arrays.fill(freq, 0);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }
 
        // Step 2: Initialize the left and
        // right pointers, and the
        // direction counter
        int l = 0, r = s.length() - 1, f = 0;
        while (l <= r) {
 
            // Step 3: If the counter is
            // zero, move the left pointer,
            // otherwise, move the
            // right pointer
            if (f == 0) {
 
                // Step 4: Check if the
                // frequency count of the
                // character at the current
                // pointer isgreater than 1
                char ch = s.charAt(l);
                if (freq[ch - 'a'] == 1) {
 
                    // If the frequency count
                    // is equal to 1, move
                    // the pointer without
                    // changing direction
                    l++;
                }
                else {
                    // Otherwise, decrement
                    // the frequency count
                    // by 1 and change the
                    // direction of the
                    // pointers
                    freq[ch - 'a']--;
                    s.replace(l, l + 1, "#");
                    l++;
                    f ^= 1;
                }
            }
            else {
                char ch = s.charAt(r);
                if (freq[ch - 'a'] == 1) {
                    r--;
                }
                else {
                    freq[ch - 'a']--;
                    s.replace(r, r + 1, "#");
                    r--;
                    f ^= 1;
                }
            }
        }
 
        // Step 5: Replace non-alphabetic
        // characters with a placeholder
        // and remove them later
        // Step 6: Iterate over the input
        // string and append any alphabetic
        // characters to a new output string
        if (f == 1)
            s.reverse();
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#')
                ans += s.charAt(i);
        }
 
        // Step 7: If the counter variable
        // is equal to 1, reverse the
        // output string before returning it
        return ans;
    
        
    }
} 

//{ Driver Code Starts.

// } Driver Code Ends