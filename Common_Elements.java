//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();
            
            int A[] = new int[n1];
            int B[] = new int[n2];
            int C[] = new int[n3];
            
            for (int i = 0;i < n1;i++)
            {
                A[i] = sc.nextInt();
            }
            for (int i = 0;i < n2;i++)
            {
                B[i] = sc.nextInt();
            }
            for (int i = 0;i < n3;i++)
            {
                C[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            ArrayList<Integer> res = sol.commonElements(A, B, C, n1, n2, n3);
            if (res.size() == 0)
            {
                System.out.print(-1);
            }
            else 
            {
                for (int i = 0;i < res.size();i++)
                {
                    System.out.print(res.get(i) + " ");
                }    
            }
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) 
    {
        // code here 
        LinkedHashSet<Integer> h=new LinkedHashSet<>();
        LinkedHashSet<Integer> h2=new LinkedHashSet<>();
        LinkedHashSet<Integer> h3=new LinkedHashSet<>();
        LinkedHashSet<Integer> h4=new LinkedHashSet<>();
        for(int i=0;i<n1;i++){
            h.add(A[i]);
        }
        for(int i=0;i<n2;i++){
            h2.add(B[i]);
        }
        
        for(int i=0;i<n3;i++){
            h3.add(C[i]);
        }
        //HashSet<Integer> h=new HashSet<>();
        for(Integer it : h){
            if(h2.contains(it) && h3.contains(it)){
                h4.add(it);
            }
        }
        ArrayList<Integer> arr=new ArrayList<>(h4);
        
        return arr;
    }
}