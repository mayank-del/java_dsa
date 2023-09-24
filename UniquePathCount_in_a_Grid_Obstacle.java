class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
		// Write your code here.
		int dp[][]=new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				dp[i][j]=-1;
			}
		}

		return f(m-1,n-1,dp, obstacleGrid);

	}
	int f(int i,int j,int dp[][],int mat[][]){
		
      if(i>=0 && j>=0 && mat[i][j]==1) return 0;
      if(i==0 && j==0) return 1;

		if(i<0 || j<0){
			return 0;
		}
		if(dp[i][j]!=-1) return dp[i][j];
		int up=f(i-1,j,dp,mat);
		int left=f(i,j-1,dp,mat);

		return dp[i][j]=up + left;
	}
}