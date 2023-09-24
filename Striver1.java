import java.util.*;
public class Striver1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int row=sc.nextInt();
        int col=sc.nextInt();
        int arr[][]=new int[row][col];
/*         int rowIndex[]=new int[row];
        int colIndex[]=new int[col]; */
        System.out.println("enter mat:");
        for(int i=0;i<col;i++){
            for(int j=0;j<row;j++){
                arr[i][j]=sc.nextInt();
            }
        }

        for(int i=0;i<col;i++){
            for(int j=0;j<row;j++){
                if(arr[i][j]==0){
                    for(int k=0;k<row;k++){
                        arr[i][k]=-1;
                    }
                    for(int k=0;k<col;k++){
                        arr[k][j]=-1;
                    }

                }

               
            }
            
        }
        System.out.println("entred mat is:");

        for(int i=0;i<col;i++){
            for(int j=0;j<row;j++){
                if(arr[i][j]==-1)
                System.out.print(0 +" ");
                else
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
