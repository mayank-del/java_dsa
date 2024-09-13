// Online Java Compiler
// Use this editor to write, compile and run your Java code online
//if number is palindrome then we will print it is odd or even
import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> arr=new ArrayList<>();
        int num=sc.nextInt();
        fibo(0,num,arr);
        System.out.println(arr);
        
        
    }
    public static void fibo(int num,int end, ArrayList<Integer> arr){
        if(arr.size()==end) return;
        if(num==0 || num==1){
            arr.add(num);
        }
        else if(num==2){
            arr.add(1);
        }
        else{
            arr.add(arr.get(num-1)+arr.get(num-2));
        }
        fibo(num + 1, end, arr);
        
    }
}