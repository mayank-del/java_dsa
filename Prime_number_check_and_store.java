import java.util.Scanner;
import java.util.ArrayList;

class Prime_number_check_and_store{
    public statSic  boolean isPrime(int n){
        for(int i=2;i*i<=n;i++){
            if(n<=1){
                return false;
            }
            if(n%i==0){
                //System.out.print("not prime");

               return false; 
            }

        }
        return true;
    }
    public static void main(String args[]){
        System.out.print("Enter number:");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();

        for(int i=n-2;i>1;i--){
            int num1=i;
            int num2=n-i;
            if(isPrime(num1) && isPrime(num2)){
                System.out.print("Yes possible");
                System.exit(0);
            }
        }
        System.out.print("Not possible");
        /* for(Integer it:arr){
        

        } */
        
    }
}