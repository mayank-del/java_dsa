

public class Striver4 {
    public static void main(String[] args) {
        int arr[]={-2,1,-3,4,-1,2,1,-5,4};
        int sum=0;
        int max_sum=arr[0];
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum>max_sum)
                max_sum=sum;
            if(sum<0)
                sum=0;
        }
        System.out.println(max_sum);

        
    }
}
