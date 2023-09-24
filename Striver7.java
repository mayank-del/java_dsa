import java.util.Scanner;

public class Striver7 {
    public static void main(String[] args) {
        int temp_row=2;
        Scanner sc=new Scanner(System.in);
        int arr[][]=new int[3][3];
        int b[][]=new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                arr[i][j]=sc.nextInt();
            }
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                
                b[j][temp_row]=arr[i][j];
            

            }
            temp_row--;
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(b[i][j]+" ");
            }
        System.out.println();
        }
    }
}
