// question is from 1 to n , find missing number.

/* public class Cyclic_sort_missingNo {
    public static void main(String[] args) {
        int arr[]={4,2,5,6,1,8,7,10,9};
        int search[]=new int[arr.length+1];
        int missingNo=0;

        for(int i=0;i<arr.length;i++){
            int correct=arr[i]-1;
            search[correct]=correct+1;
            
        }
        for(int i=0;i<search.length;i++){
            if(search[i]==0){
                missingNo=i+1;
            }
        }
        System.out.println("Missing Number is: "+ missingNo);
    }
} */
//optimised code code for 0 to n, missing number
public class Cyclic_sort_missingNo {
    public static void main(String[] args) {
        int arr[]={0,4,2,5,6,1,8,7,10,9};
       
        int i=0;
        while(i<arr.length){
            
            int correct=arr[i];
            
            if(arr[i]<arr.length && arr[i]!=arr[correct]){
                swap(arr,i,correct);
            }
            else{
                i++;
            }
            
        }
        System.out.println(check(arr)); 
      
     
     
        
       // System.out.println("Missing Number is: ");
    }
    static void swap(int arr[],int a,int b){
            int temp=arr[a];
            arr[a]=arr[b];
            arr[b]=temp;
    }
    static int check(int arr[]){
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=i){
                return i;
            }
            
        }
        return arr.length;
    }
}


