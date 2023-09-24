class Solution {
    public int maxProfit(int[] prices) {
        return f(0,prices,prices.length,true);
    }
    int f(int ind,int prices[],int n, boolean buy){
        if(ind==n){
            return 0;
        }
        int profit= Integer.MIN_VALUE;
        if(buy){
            profit=Math.max(-prices[ind] + f(ind+1,prices,n,false),0 + f(ind+1,prices,n,true));
        }else{
            profit=Math.max(prices[ind] + f(ind+1,prices,n,true),0 + f(ind+1,prices,n,false));
        }
        return profit;
    }
}


//Memoisation



class Solution {
    public int maxProfit(int[] prices) {

        int dp[][]=new int[prices.length][2];

        for(int i=0;i<prices.length;i++){
            for(int j=0;j<2;j++){
                dp[i][j]=-1;
            }
        }

        return f(0,prices,prices.length,1,dp);
    }
    int f(int ind,int prices[],int n, int buy,int dp[][]){
        if(ind==n){
            return 0;
        }
        if(dp[ind][buy]!=-1) return dp[ind][buy];
        int profit= Integer.MIN_VALUE;
        if(buy==1){
            profit=Math.max(-prices[ind] + f(ind+1,prices,n,0,dp),0 + f(ind+1,prices,n,1,dp));
        }else{
            profit=Math.max(prices[ind] + f(ind+1,prices,n,1,dp),0 + f(ind+1,prices,n,0,dp));
        }
        return dp[ind][buy]=profit;
    }
}