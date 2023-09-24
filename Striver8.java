import java.util.Scanner;

public class Striver8 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int a[][]={{1,3},{2,6},{8,10},{9,12},{15,18}};
        int b[][]=new int[a.length][a[0].length];
        int index_to_be_skipped=0;
        boolean checked=false;
    /*     for(int i=0;i<4;i++){
            for(int j=0;j<2;j++){
                a[i][j]=sc.nextInt();
            }
            
        } */
    for(int i=0,k=0;i<5;i++){
            for (int j=0,l=0;j<2;j++){
            if(i<3){   
                if(a[i][1]>=a[i+1][0]){
                    a[i][1]=a[i+1][1];
                    //i++;
                    if(!checked){
                        index_to_be_skipped++;
                        checked=true;
                        }
                    }
            }
                if(index_to_be_skipped>0){
                    b[k][l++]=a[i][j];
                    i++;
                    index_to_be_skipped=0;
                }
                else{
                    b[k][l++]=a[i][j];
                }    
            }
            k++;
            checked=false;
        }
        for(int i=0;i<5;i++){
            for(int j=0;j<2;j++){
                System.out.print(b[i][j]+" ");
            }
            System.out.println();
        }
    
    }
}
