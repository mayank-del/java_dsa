import java.util.*;

class ArrayList_tcs_print_All_subarray_whose_sum_is_k{
    public static void main(String args[]){

        Scanner sc=new Scanner(System.in);
        String inpStr=sc.nextLine();

        String strArr[]=inpStr.split(" ");
        int n=strArr.length;
        int arr[]=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(strArr[i]);
        }
        int k=sc.nextInt();
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();

        for(int i=0;i<n;i++){
            int sum=arr[i];
            ArrayList<Integer> list=new ArrayList<>();
            list.add(arr[i]);
            for(int j=i+1;j<n;j++){
                sum+=arr[j];
                list.add(arr[j]);
                if(sum==k){
                    res.add(new ArrayList<>(list));
                    //res.add();

                }
            }
        }

        for(int i=0;i<res.size();i++){
            for(int j=0;j<res.get(i).size();j++){
                System.out.print(res.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}

//1 4 5 2 -9 -2 2 3 1 4 -5