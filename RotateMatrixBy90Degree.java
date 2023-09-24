class Solution {
    public void rotate(int[][] matrix) {
        int start=0,end=matrix.length;
        
        for(int i=0;i<end;i++){
            if(start<end){
            for(int j=start;j<end-1;j++){
                
                //System.out.print(matrix[i][j]+" ");
                int temp;
                temp=matrix[i][j];
                matrix[i][j]=matrix[matrix.length-1-j][i];
                matrix[matrix.length-1-j][i]=matrix[matrix.length-1-i][matrix.length-1-j];
                matrix[matrix.length-1-i][matrix.length-1-j]=matrix[j][matrix.length-1-i];
                matrix[j][matrix.length-1-i]=temp;
             
                //System.out.println("Doing rotn");

        }
        //System.out.println("i="+i+" "+start+" "+" "+end);

        start++;
        end--;
    }
    }
}
}