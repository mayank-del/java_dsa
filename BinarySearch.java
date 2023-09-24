/* public class BinarySearch {
    public int bin(int low,int high,int key,int arr[]){
        int mid=(low+high)/2;
        if(arr[low]==arr[high]){
            if(arr[low]==key)
                return arr[low];
            else 
                return 0;
        }
        else{
            if(arr[mid]==key ||arr[low]==key || arr[high]==key){
                return key;
            }
            else if(arr[mid]>key){
                high=mid-1;
                return bin(low,high,key,arr);
            }
            else if(arr[mid]<key){
                low=mid+1;
                return bin(low,high,key,arr);
            }
            else{
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        int arr[]={1,3,4,67,91,100,121,131};
        int search=11;
        BinarySearch obj=new BinarySearch();
        int result =obj.bin(0, arr.length-1, search, arr);
        if(result==0){
            System.out.println("Not present");
        }else{
            System.out.println("Yes present");
        }
    }
} */

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

  public class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int key = sc.nextInt();
            Solution g = new Solution();
            System.out.println(g.binarysearch(arr, n, key));
            T--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int binarysearch(int arr[], int n, int k) {
        // code here
        int low=0;
        int high=n-1;
        for(; low<=high ;){
            int mid=(low+high)/2;
            
            if(k==arr[mid]) return mid;
            else if(k>arr[mid]) low=mid+1;
            else high=mid-1;
        }
        
        return -1;
    }
}
