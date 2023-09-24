//Maxm profit on sell
import java.util.Scanner;

public class Striver6 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int arr[]=new int[5];

        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        int high=arr[0];
        int low=arr[0];
        int index_of_smallest=0;
        int index_of_largest=0;
        int profit=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]>=high){
                high=arr[i];
                index_of_largest=i;
            } 
           
            if(low>=arr[i]){
                low=arr[i];
                index_of_smallest=i;
            }
        }
       /*  System.out.println(high);
        System.out.println(low); */
        if(index_of_largest>index_of_smallest){
        
            profit=arr[index_of_largest]-arr[index_of_smallest];
            System.out.println("profit is:"+profit);
        }
        else{

            high=arr[index_of_smallest];
            for(int i=index_of_smallest;i<arr.length;i++){
                if(arr[i]>=high){
                    high=arr[i];
                }
                
            }
            
            /* System.out.println(index_of_smallest);
            System.out.println(high); */
            profit=high-arr[index_of_smallest];
            System.out.println("profit is:"+profit);
        }
    }
}
