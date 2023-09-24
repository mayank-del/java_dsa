//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int arr[])
    {
        // Code here
        int count=0;
        int n=arr.length;
        int copy[]=new int[n] ;
        for(int i=0;i<n;i++)copy[i]=arr[i];

        Arrays.sort(copy);

        HashMap<Integer,Integer> h =new HashMap<>();
        for(int i = 0;i<n;i++){
            h.put(copy[i],i);
        }
                    int i=0;
                    while(i<n ) {
                        //swap(arr,i,h.get(arr[i]));
                        
                        if(i!=h.get(arr[i])){
                            int j= h.get(arr[i]);
                            int temp=arr[i];
                            arr[i]=arr[j];
                            arr[j]=temp;
                            count++;
                        
                        }else{
                            i++;
                        }
                }
            
            
        
        return count;
    }
}