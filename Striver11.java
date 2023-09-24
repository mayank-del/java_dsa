public class Striver11 {
    public static void main(String[] args) {
        int arr[]={1,8,3,5,7,2,6,2};
        int i=0;
        while(i<arr.length){
            int correct =arr[i]-1;
            if(correct!=i){
                if(arr[correct]==arr[i]){
                    System.out.println("Duplicate element is:"+arr[i]);
                    System.out.println("Missing element is:"+(int)(i+1));
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
