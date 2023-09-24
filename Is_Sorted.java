public class Is_Sorted {
    public static boolean isSorted(int arr[],int idx){
        if(idx==arr.length-1){
            return true;
        }
        if(arr[idx]<arr[idx+1]){
           return isSorted(arr,idx+1);
           
        }
        else{
            return false;
        }
    }
    public static void main(String args[]){
        int arr[]={1,2,3,4,5};
        boolean newb=isSorted(arr, 0);
        if(newb==true){
            System.out.println("sorted");;
        }
        else{
            System.out.println("Unsorted");
        }
    }
}
