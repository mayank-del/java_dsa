class Solution {
    public int[][] largestLocal(int[][] grid) {
       
        int n=grid.length-2;
        int m=grid[0].length-2;
        int res[][]=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                res[i][j]=add(i,j,grid);
            }
        }
        return res;
    }

    public int add(int x,int y,int grid[][]){
        int max=-1;
        for(int i=x;i<x+3;i++){
            for(int j=y;j<y+3;j++){
                max=Math.max(max,grid[i][j]);
            }
        }

        return max;
    }
}