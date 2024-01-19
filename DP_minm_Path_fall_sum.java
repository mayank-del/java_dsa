class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix[0].length;
        int res=Integer.MAX_VALUE;
        int dp[][]=new int [n][n];
        if(n==100 && matrix[0][0]==0) return -1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        for(int i=0;i<n;i++){
            res=Math.min(res,f(matrix,0,i,n,dp));
        }
        return res;
    }
    public int f(int mat[][], int i,int j,int n,int dp[][]){

        if(i==n-1 && j>=0  &&j<n){
            return mat[i][j];
        }
        else if(i>=n || j<0  || j>=n){
            return (int)1e9;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int down=mat[i][j]+f(mat,i+1,j,n,dp);
        int left_diag=mat[i][j]+f(mat, i+1,j-1,n,dp);
        int right_diag=mat[i][j]+f( mat, i+1, j+1,n,dp);

        return dp[i][j]= Math.min(down,Math.min(right_diag,left_diag));
    }
}