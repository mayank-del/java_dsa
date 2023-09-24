import java.util.Arrays;

/*Q1.>     when we can implement quicksort and when we acn implement mergesort?
 * ans-->  Quicksort can be implemented in the case where time is not the issue but memory is the issue,bcoz it takes 
 * less memory but in worst case it's time complexity becomes O(n) instead of O(nlogn) while merge sort will always have time complexity
 * as O(nlogn) ,but it takes more mermory bcoz we have to  declare an array and store sorted values in it.
 * 
 */

public class Mergesort {
    public static void conquer(int arr [],int start,int mid, int end){
        int merged[]=new int[end-start+1];

        int idx1=start;
        int idx2=mid+1;
        int x=0;

        while(idx1<=mid && idx2<=end){
            if(arr[idx1]<=arr[idx2]){
                merged[x++]=arr[idx1++];
            }
            else{
                merged[x++]=arr[idx2++];
            }
        }
        while(idx1<=mid){
            merged[x++]=arr[idx1++];
        }
        while(idx2<=end){
            merged[x++]=arr[idx2++];
        }
        for(int i=0,j=start;i<merged.length;i++,j++){
            arr[j]=merged[i];
        }

    }
    public static void divide(int arr [],int start, int end){
       if(start>=end){
        return;
       } 
       int mid =start+(end - start)/2;

       divide(arr, start, mid);
       divide(arr,mid+1,end);

       conquer(arr,start,mid,end);
    }

    public static void main(String args[]){
        int arr[]={35,3,1,200,150,300};
        int n=arr.length;

        divide(arr,0,n-1);

        for(int i=0;i<n;i++){
            System.out.println(arr[i]+" ");
        }
        System.out.println();
    }
    
}

/* 
 public  class Mergesort{
    public static void main(String[] args) {
        int arr[]={2,1,5,3,23};
        arr=mergeSort(arr);
        System.out.println(Arrays.toString(arr));
        
    }
    public static int[] mergeSort(int[] arr){
        if(arr.length==1){
            return arr;
        }
        int mid=arr.length/2;

        int[] left=mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int [] right=mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left,right);
    }
    public static int[] merge(int a[],int b[]){
        int i=0,j=0,k=0;
        int c[]=new int[a.length+b.length];
    
        for(;i<a.length && j<b.length;){
            if(a[i]>b[j]){
                c[k]=b[j];
                j++;
            }else{
                c[k]=a[i];
                i++;
               
            }
            k++;
        }
        while(i<a.length){
            c[k]=a[i];
            k++;
            i++;
        }
        while(j<b.length){
            c[k]=b[j];
            k++;
            j++;
        }
        return c;
    }
 } */
/* 
public class Mergesort{

    public static void conquer(int arr[],int si,int mid,int ei){
        int merged[] = new int[ei-si +1];

        int idx1=si;
        int idx2=mid+1;
        int x=0;

        

    }

    public static void divide(int arr[],int si, int ei){
        if(si>=ei){
            return;
        }
       int mid=si +(ei-si)/2;
       divide(arr,si,mid);
       divide(arr,mid+1,ei);
       conquer(arr,si,mid,ei);
    }
    public static void main(String[] args) {

    }
} */