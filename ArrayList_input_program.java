import java.util.Scanner;
import java.util.ArrayList;
class HelloWorld {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size:");
        int n= sc.nextInt();
        
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            System.out.println("Enter "+i+" number:");
            int num= sc.nextInt();
            arr.add(num);
        }
        System.out.println(arr);
    }
}