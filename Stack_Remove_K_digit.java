//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKdigits(S, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    /*public String removeKdigits(String S, int K) {
        // code here
        Stack<Character> st=new Stack<>();
        
        
        for(int i=0;i<S.length();i++){
            char ch=S.charAt(i);
            if(K==0){
                st.push(ch);
            }
            else if(st.isEmpty() && ch-'0'!=0){
                st.add(ch);
            }
            else if(!st.isEmpty() &&  ch-'0' > st.peek()-'0' && K>0){
                K--;
                continue;
            }
            
            else if(!st.isEmpty() &&  ch -'0' < st.peek()-'0'){
                if(K>0 && ch -'0'==0){
                   st.pop();
                   K--;
                   continue;
                }
                else if(K>0){
                    st.pop();
                    K--;
                }
                st.push(ch);
                
            }else if(!st.isEmpty() &&  ch -'0' == st.peek()-'0'){
                if(K>0){
                    st.pop();
                    K--;
                }
                st.push(ch);
                
            }
        }
        String res="";
        for(;!st.isEmpty();){
            res+=st.pop();
        }
        char arr[]=res.toCharArray();
        for(int i=0;i<res.length()/2;i++){
            char temp=arr[i];
            arr[i]=arr[arr.length-i-1]; 
            arr[arr.length-i-1]=temp;   
        }
        res=new String(arr);
        if(K>=res.length()){
            //res=res.substring(K);
            res="0";
        }
        
        return res;
        
    }*/
    
    
    public String removeKdigits(String S, int K) {
          Stack<Character> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            while (!stack.isEmpty() && stack.peek() > c && K > 0) {
                stack.pop(); //  stack  in ascending order
                K--;        // number of deletion remaining
            }

            // if (!stack.isEmpty()) {//push c irres of its 0 or not 
            //      stack.push(c);
            // } 
            // if(stack.isEmpty() && c!='0')
            // stack.push(c);
             
            //  if(stack.isEmpty() && c=='0') // no leading zeros
            //  continue;
            
            if(!stack.isEmpty() || c!='0')
             stack.push(c);
        }   
        // number of deletion remaining >0
        while (!stack.isEmpty() && K > 0) {
            stack.pop();
            K--;
        } 

        if (stack.isEmpty()) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        // Appends characters one by one
        for (Character ch : stack) {
            sb.append(ch); //O(1)
        }

        return sb.toString();
    }
}