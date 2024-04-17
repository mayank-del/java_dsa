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
