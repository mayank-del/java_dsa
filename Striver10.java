public class Striver10 {
    public static void main(String[] args) {
        int arr[]={1,3,5,2,2};
        int i=0;
        while(i<arr.length){
            int correct =arr[i]-1;
            if(correct!=i){
                if(arr[correct]==arr[i]){
                    System.out.println("Duplicate element is:"+arr[i]);
                    
                    break;
                }
                swap(arr,i,correct);
            }
            else{
                i++;
            }
        }

    }
    public static void swap(int arr[],int a, int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
  
}
/*         for(i=0;i<arr.length;i++){
            System.out.print(arr[i] +" ");
        } */
