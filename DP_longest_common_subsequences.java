class Solution {
    public int longestCommonSubsequence(String s, String t) {
        int ind1=s.length();
		int ind2=t.length(); 
		int dp[][]=new int[ind1][ind2];
		for(int i=0;i<ind1;i++){
			for(int j=0;j<ind2;j++){
				dp[i][j]=-1;
			}
		}
		return f(s,ind1-1,t,ind2-1,dp);
    }
	static int f(String s, int ind1,String t,int ind2 ,int[][] dp){
		if(ind1<0 || ind2<0){
			 return 0;
		}
		if(dp[ind1][ind2]!=-1){
			return dp[ind1][ind2];
		}

		if(s.charAt(ind1)==t.charAt(ind2)){
			return dp[ind1][ind2]= 1+f(s,ind1-1,t,ind2-1,dp);
		}
		else{
			return dp[ind1][ind2]= Math.max(f(s,ind1-1,t,ind2,dp),f(s,ind1,t,ind2-1,dp));
		}
	}
}