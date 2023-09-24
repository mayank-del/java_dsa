import java.util.ArrayList;
//import java.util.Scanner;

public class Striver_greedy1 {
    public static void main(String[] args) {
        int a[]={1,0,3,8,5,8};
        int b[]={2,6,4,9,7,9};
       // Scanner sc=new Scanner(System.in)
    
        ArrayList<Integer>meetingStore = new ArrayList<>();
        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-i-1;j++){
                if(b[i]>b[i+1]){
                    int temp=b[i];
                    b[i]=b[i+1];
                    b[i+1]=temp;
                    int temp2=a[i];
                    a[i]=a[i+1];
                    a[i+1]=temp2;
                }
            }
          
        }
        meetingStore.add(1);
        for(int i=0,j=i+1;j<a.length;j++){
            if(a[j]>b[i]){
                meetingStore.add(j+1);
                i=j;
            }
        }
        
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+",");
        }
        System.out.println();
        for(int i=0;i<a.length;i++){
            System.out.print(b[i]+",");
        }
        System.out.print(meetingStore);

    }
}
