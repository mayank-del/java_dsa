//Solved by me//

/* public class Insertionsort {
    int a,b;
    void swap(int a,int b){
        int temp=a;
        a=b;
        b=temp;
        
    }
    public static void main(String[] args) {
        int a[]={34,2,12,5,1,3,123,17,20,14,2343};
        int sorted[]=new int[a.length];

        for(int i=0;i<a.length;i++){
           sorted[i]=a[i];
           for(int j=0;j<=i;j++) {
            int z=i;
                for(int k=i;k>0;k--){
                    if(sorted[z]<sorted[k-1]){
                        int temp=sorted[z];
                        sorted[z]=sorted[k-1];
                        sorted[k-1]=temp;
                        z--;
                    }
                } 
           }
        }
        for(int i=0;i<a.length;i++){
            System.out.println(sorted[i]);
        }
    }
}
 */

 
import java.util.Arrays;

class Insertionsort {

  void insertionSort(int array[]) {
    int size = array.length;

    for (int step = 1; step < size; step++) {
      int key = array[step];
      int j = step - 1;

      // Compare key with each element on the left of it until an element smaller than
      // it is found.
      // For descending order, change key<array[j] to key>array[j].
      while (j >= 0 && key < array[j]) {
        array[j + 1] = array[j];
        --j;
      }

      // Place key at after the element just smaller than it.
      array[j + 1] = key;
    }
  }

  // Driver code
  public static void main(String args[]) {
    int[] data = { 9, 5, 1, 4, 3 };
    Insertionsort is = new Insertionsort();
    is.insertionSort(data);
    System.out.println("Sorted Array in Ascending Order: ");
    System.out.println(Arrays.toString(data));
  }
}