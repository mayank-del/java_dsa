/* public class Quicksort {

    public static int partition(int a[],int low,int high){
        int pivot=a[high];
        int i= low-1;//for catching smaller elem than pivot,but here assuming no elem is smaller than pivot

        for(int j=low;j<high;j++){
            if(a[j]<pivot ){
                i++;
                //swap
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        i++;
        int temp=a[i];
        a[i]=pivot;
        a[high]=temp;
        return i;
    }
    
    public static void quicksort(int a[],int low,int high){
        if(low<high){
            int pivotIndex=partition(a,low,high);
            quicksort(a,low,pivotIndex-1);
            quicksort(a,pivotIndex+1,high);
        }
       
    }
    public static void main(String args[]){
        //int a[]=new int[5];
        int a[]={43,2,5,12,56};
        int n=a.length;
        quicksort(a,0,n-1);

        for(int i=0;i<n;i++){
            System.out.println(a[i]);
        }
        
    }
}
 */

 
public class Quicksort{

    public static int partition(int arr[],int low,int high){
        int pivot=arr[high];
        int i=low-1;

        for(int j=low;j<high;j++){
            if(arr[j]<pivot){
                i++;

                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;

            }
            
        }
        i++;
        int temp=arr[i];
        arr[i]=pivot;
        arr[high]=temp;
        System.out.println(i);

        return i;
    }

    public static void quickSort(int arr[],int low,int high){
        if(low<high){
            int pivotIndex=partition(arr,low,high);

            quickSort(arr, low, pivotIndex-1);
            quickSort(arr, pivotIndex+1, high);
        }
    }
    public static void main(String[] args) {
        int [] arr={6,1,3,9,5,8};
        int n =arr.length;

        quickSort(arr,0,n-1);

    }
}