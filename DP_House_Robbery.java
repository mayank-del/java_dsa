class Solution {
    public int rob(int[] nums) {

        int dp[]=new int [nums.length];

        Arrays.fill(dp,-1);

        return f(0,nums,dp);

    }

    public int f(int ind, int nums[],int dp[]){
        
        if(ind > nums.length-1){
            return 0;
        }
        if(dp[ind]!=-1)return dp[ind];
        int take=nums[ind]+f(ind+2,nums,dp);
        int notTake=f(ind+1,nums,dp);
        return dp[ind]=Math.max(take,notTake);
    }
}