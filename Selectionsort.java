/* here we only try to find smallest element in array and swap that eleement with 1st element in array
 * 
 * 
 */

public class Selectionsort {
    public static void main(String[] args) {
        int a[]={2,1,3,4,5,10,9,8,90,56};
        //int index=0;
        for(int i=0;i<a.length-1;i++){
        int smallest=i;

            for(int j=i+1;j<a.length;j++){
                if(a[smallest]>a[j]){
                    smallest=j;
                        
                }
                
            }
            
            int temp=a[i];
            a[i]=a[smallest];
            a[smallest]=temp;
           // a[i]=smallest;
        }
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
        
    }
}
