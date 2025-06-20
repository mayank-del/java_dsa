import java.util.*;
/* //method overloading practice

class Play{
    
    public static String meth1(int num){
        String res="Returned integer is:"+num;
        return res;
    }
    public static String meth1(int num,boolean b){
        String res="Returned integer is:"+num+","+"Status is:"+b;
        return res;
    }
}
class HelloWorld {
    public static void main(String[] args) {
        Play p=new Play();
        String stored=p.meth1(6,false);
        System.out.print(stored);
    }
}


//Arraylist 2D update method 



import java.util.ArrayList;
import java.util.Scanner;
class HelloWorld {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        arr.add(new ArrayList<>());
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<5;i++){
            System.out.print("Enter your number:");
            int data=sc.nextInt();
            arr.get(0).add(data);
        }
        arr.get(0).set(2,785878);
        for(Integer it:arr.get(0)){
            System.out.print(it+",");
        }
    }
} */
class Practice_part{
    static int maxMedian = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int ind=0;
        int nums[]={29,34,15,18,9};
        int k=3;
        //maxm suseq sum with
        List<Integer> current=new ArrayList<>();
        f(nums,ind,current,k);
        System.out.println(maxMedian);
    }

    private static void f(int[] arr, int index, List<Integer> current, int k) {
        // Base case: if current subsequence has size k
        if (current.size() == k) {
            List<Integer> temp = new ArrayList<>(current);
            Collections.sort(temp);
            int median = temp.get((k - 1) / 2); // use lower middle for even k
            maxMedian = Math.max(maxMedian, median);
            return;
        }

        // If we reach the end or current size > k
        if (index == arr.length || current.size() > k) {
            return;
        }

        // Pick the current element
        current.add(arr[index]);
        f(arr, index + 1, current, k);

        // Backtrack - remove last element and explore not-pick
        current.remove(current.size() - 1);
        f(arr, index + 1, current, k);
    }
}
