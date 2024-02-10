class Solution {
    long numberOfPath(int n, int k, int [][]arr) {
        // code here
        long res[]={0};
        long sum[]={0};
        //int dp[][]=new int[n][n];
        
        f(0,0,arr,res,sum,n,k);
        return res[0];
    }
    void f(int i, int j, int[][] arr, long res[], long sum[], int n, int k) {
        if (i >= n || j >= n) {
            return;
        }
        sum[0] += arr[i][j];
        if (i == n - 1 && j == n - 1 && sum[0] == k) {
            res[0]++;
        }
        
        // Explore downwards
        f(i + 1, j, arr, res, sum, n, k);
        // Explore to the left
        f(i, j + 1, arr, res, sum, n, k);
        // Backtrack: Subtract the current element from the sum
        sum[0] -= arr[i][j];
    }
}