//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        
        Arrays.sort(arr, (a, b) -> {
            double ratioA = (double) a.value / a.weight;
            double ratioB = (double) b.value / b.weight;
            if (ratioA < ratioB) {
                return 1; // Indicates that 'a' should come after 'b' (descending order).
            } else if (ratioA > ratioB) {
                return -1; // Indicates that 'a' should come before 'b' (descending order).
            } else {
                return 0; // Indicates that 'a' and 'b' are equal in terms of ratio.
            }
        });

        
        double val=0;
        for(int i=0;i<n;i++){
            if(W-arr[i].weight>=0){
                W-=arr[i].weight;
                val+=(double)arr[i].value;
            }else{
                val+=(double)arr[i].value*((double)W/arr[i].weight);
                break;
            }
        }
        return val;
    }
}