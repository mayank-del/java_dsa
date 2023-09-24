public class CyclicSort {
    public static void main(String[] args) {
        //int arr[]={5,2,1,4,6,3};
        //int arr[]={3,4,2,5,6,1,8,7,10,9};
        int arr[]={2,0,1,0,2,1,0,2,1};

        int i=0;
        while(i<arr.length){/* cyclic sort means numbers should be continuos order from 1 to n and we will just do 1 round traversal by always remembering formula that correct index should be arr[i]-1 (i.e. for number 8 ,it should be 7th index , for number 9 ,it should be 8th index)*/
            int correct=arr[i]-1;
            if(i!=correct){
                swap(arr,i,correct);
            }else{
                i++; //once checking finished ,then only do i++
            }
            
        }
        for(i=0;i<arr.length;i++){
            System.out.print(arr[i] +" ");
        }
    }
    static void swap(int arr [],int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;    
    }
}
