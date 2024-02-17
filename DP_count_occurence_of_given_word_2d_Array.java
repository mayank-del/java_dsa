//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 
        
        Integer nextInt(){
            return Integer.parseInt(next());
        }
    } 
    
    public static void main(String args[])
    {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t>0)
        {
            int R = sc.nextInt();
            int C = sc.nextInt();
            
            char mat[][] = new char[R][C];
            for(int i=0;i<R;i++)
            {
                for(int j=0;j<C;j++)
                {
                    mat[i][j] = sc.next().charAt(0);
                }
            }
            String target  = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.findOccurrence(mat,target));
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int findOccurrence(char mat[][], String target)
    {
        // Write your code here
        
        int res = 0;
        
        for(int i = 0 ; i < mat.length ; i++){
            
            for(int j = 0 ; j < mat[0].length ; j++){
                
                res += helper(mat , i , j , target , 0);
            }
        }
        
        return res;
    }
    
    int helper(char mat[][] , int i , int j , String target , int idx){
        
        int found = 0 ; 
        
        if(i < mat.length && i >= 0 && j < mat[0].length && j>=0 &&
                    target.charAt(idx) == mat[i][j]){
            
            mat[i][j] = '#';
            
            if(idx == target.length()-1){
                
                found = 1;
            }
            
            else{
                
                found += helper(mat , i , j-1 , target , idx+1);
                found += helper(mat , i+1 , j , target , idx+1);
                found += helper(mat , i-1 , j , target , idx+1);
                found += helper(mat , i , j+1 , target , idx+1);
            }
            
            mat[i][j] =  target.charAt(idx);
        }
        
        return found;
    }
}