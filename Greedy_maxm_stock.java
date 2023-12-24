//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String str=br.readLine();
    		String[] starr=str.split(" ");
    		
    		//input n and d
    	    int n=Integer.parseInt(starr[0]);
    		int k= Integer.parseInt(starr[1]);
            
            starr = br.readLine().trim().split(" ");
            int[] price = new int[n];
            for(int i = 0; i < n; i++)
                price[i] = Integer.parseInt(starr[i]);
            
            Solution obj = new Solution();
            int res = obj.buyMaximumProducts(n, k, price);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends

class Pair{
    int data;
    int maxm_limit;
    
    Pair(int data,int maxm_limit){
        this.data=data;
        this.maxm_limit=maxm_limit;
    }
}
class Solution {
    public static int buyMaximumProducts(int n, int k, int[] price) {
        // code here
        Pair[] p=new Pair[n];
        for(int i=0;i<price.length;i++){
            p[i]=new Pair(price[i],i+1);
        }
        
        Arrays.sort(p,(a,b)->a.data-b.data);
        int count=0;
        
        for(int i=0;i<p.length;i++){
            for(int j=0;j<p[i].maxm_limit;j++){
                if(p[i].data<=k){
                    k-=p[i].data;
                    count++;
                }
            }
        }
        
        return count;
    }
}
        
//o(n)

public static int buyMaximumProducts(int n, int k, int[] price) {
        // code here
        Pair[] p=new Pair[n];
        for(int i=0;i<price.length;i++){
            p[i]=new Pair(price[i],i+1);
        }
        
        Arrays.sort(p,(a,b)->a.data-b.data);
        int count=0;
        
        for(int i=0;i<p.length;i++){
            /*for(int j=0;j<p[i].maxm_limit;j++){
                if(p[i].data<=k){
                    
                }
            }*/
            if(p[i].data*p[i].maxm_limit<k){
                k-=p[i].data*p[i].maxm_limit;
                count+=p[i].maxm_limit;
            }else{
                int quotient=k/p[i].data;
                k-=quotient*p[i].data;
                count+=quotient;
            }
        }
        
        return count;
    }