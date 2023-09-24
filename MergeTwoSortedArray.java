public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int a[]={2,4, 5 ,9,12};
        int b[]={1,3,6,8};

        System.out.println(merge(a,b));


    }
    public static int[] merge(int a[],int b[]){
        int[] mix=new int[a.length +b.length];
        int i=0;
        int j=0;
        int k=0;

        for(;i<a.length && j<b.length;){
            if(a[i]<b[j]){
                mix[k]=a[i];
                i++;
            }
            else{
                mix[k]=b[j];
                j++;
            
            }
            k++;
        }
        while(i<a.length){
            mix[k]=a[i];
            i++;
            k++;
        }
        while(j>b.length){
            mix[k]=b[k];
            j++;
            k++;
        }
        for(int z=0;z<mix.length;z++){
            System.out.print(mix[z]+",");
        }
        return mix;
    }
}
