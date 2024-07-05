class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        return f(obstacleGrid,0,0,m,n);
    }
    int f(int arr[][],int i,int j,int m,int n){
        if(i==m-1 && j==n-1 && arr[i][j]==0){
            return 1;
        }if(i>=m || j>=n){
            return 0;
        }if(arr[i][j]==1)return 0;

        int down=f(arr,i+1,j,m,n);
        int rt=f(arr,i,j+1,m,n);

        return down+rt;
    }
}

//memoisation


class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
  
        return f(obstacleGrid,0,0,m,n,dp);
    }
    int f(int arr[][],int i,int j,int m,int n,int dp[][]){
        if(i==m-1 && j==n-1 && arr[i][j]==0){
            return 1;
        }if(i>=m || j>=n){
            return 0;
        }
        if(dp[i][j]!=-1)return dp[i][j];
        if(arr[i][j]==1)return 0;

        int down=f(arr,i+1,j,m,n,dp);
        int rt=f(arr,i,j+1,m,n,dp);

        return dp[i][j]=down+rt;
    }
}
