class Solution {
    //infinite supply problem
   public int coinChange(int[] coins, int amt) {
       int ind=coins.length-1;
       int[][] dp = new int[ind+1][amt + 1];

        // Initialize the dp array with -1 to indicate that subproblems are not solved yet
        for (int row[] : dp)
            Arrays.fill(row, -1);

       int res=f(ind,coins,amt,dp);
       if(res==1000000000) res=-1;
       return res;
}

// RECURSIVE FUNCTION

/* 

public int f(int ind,int coins[],int amt){
         if (ind == 0) {
            // If amt is divisible by the first element of the array, return the quotient
            if (amt % coins[0] == 0)
                return amt / coins[0];
            else
                // If not, return a large value to indicate it's not possible
                return (int) Math.pow(10, 9);
        }

        

        // Calculate the minimum number of elements needed without taking the current element
        int notTaken = 0 + f(ind - 1,coins, amt);

        // Initialize the minimum number of elements needed taking the current element
        int taken = (int) Math.pow(10, 9);

        // If the current element is less than or equal to amt, calculate the minimum taking it
        if (coins[ind] <= amt)
            taken = 1 + f(ind ,coins, amt - coins[ind]);

        // Store the minimum result in the dp array and return it
        return Math.min(notTaken, taken);
    
    }

 */


    public int f(int ind,int coins[],int amt,int dp[][]){
         if (ind == 0) {
            // If amt is divisible by the first element of the array, return the quotient
            if (amt % coins[0] == 0)
                return amt / coins[0];
            else
                // If not, return a large value to indicate it's not possible
                return (int) Math.pow(10, 9);
        }

        // If the result for this subproblem has already been calculated, return it
        if (dp[ind][amt] != -1)
            return dp[ind][amt];

        // Calculate the minimum number of elements needed without taking the current element
        int notTaken = 0 + f(ind - 1,coins, amt, dp);

        // Initialize the minimum number of elements needed taking the current element
        int taken = (int) Math.pow(10, 9);

        // If the current element is less than or equal to amt, calculate the minimum taking it
        if (coins[ind] <= amt)
            taken = 1 + f(ind ,coins, amt - coins[ind], dp);

        // Store the minimum result in the dp array and return it
        return dp[ind][amt] = Math.min(notTaken, taken);
    
    }
}