import java.util.ArrayList;
import java.util.List;

//ques-> from 1 to n find no mof missing numbers
public class Cyclic_sort_array_of_missingNo {
    public static void main(String[] args) {
        
        int arr[]={1,4,2,5,6,1,8,7,10,9};
        System.out.print(sort(arr));
    }
    static List<Integer> sort(int arr[]){ 
        int i=0;
        while(i<arr.length){
            
            int correct=arr[i]-1;
            
            if(arr[i]!=arr[correct]){
                swap(arr,i,correct);
            }
            else{
                i++;
            }
            
        }
        List<Integer> ans=new ArrayList<>();
        for(int index=0;index<arr.length;index++){
            if(arr[index]!=index+1){
                ans.add(index+1);
       } }
       //System.out.print(ans);
       // System.out.println("Missing Number is: ");
       return ans;
    }
    static void swap(int arr[],int a,int b){
            int temp=arr[a];
            arr[a]=arr[b];
            arr[b]=temp;
    }
    
}
