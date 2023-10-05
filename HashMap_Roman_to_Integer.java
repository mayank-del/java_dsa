//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.romanToDecimal(roman));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair {
    int prio;
    int val;
    Pair(int prio,int val){
        this.prio=prio;
        this.val=val;
    }
}
class Solution {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String str) {
        // code here
        HashMap<Character,Pair> h=new HashMap<>();
        h.put('I',new Pair(1,1));
        h.put('V',new Pair(2,5));
        h.put('X',new Pair(3,10));
        h.put('L',new Pair(4,50));
        h.put('C',new Pair(5,100));
        h.put('D',new Pair(6,500));
        h.put('M',new Pair(7,1000));
        
        int sum=0;
        Pair prev=new Pair(0,0);
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            Pair curr=h.get(ch);
            if(i>=1){
                if(curr.prio>prev.prio){
                    sum+=curr.val;
                    sum-=(2*prev.val);
                    continue;
                }
                sum+=curr.val;
            }else{
                sum+=curr.val;
            }
            prev=curr;
        }
        return sum;
    }
}