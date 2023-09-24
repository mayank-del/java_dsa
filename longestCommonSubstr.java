int longestCommonSubstr(String s, String t, int n, int m){
        // code here
        int countMax=n>m?n:m;
        int dp[][][]=new int[n][m][countMax];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<countMax;k++){
                    dp[i][j][k]=-1;
                }
                
            }
        }
        return f(s,t,n-1,m-1,0,dp);
    }
    int f(String s, String t,int ind,int ind2,int count,int dp[][][]){
        if(ind<0 || ind2<0){
            return count;
        }
        if(dp[ind][ind2][count]!=-1){
            return dp[ind][ind2][count];
        }
        int same=count;
        if(s.charAt(ind)==t.charAt(ind2)){
            same=f(s,t,ind-1,ind2-1,count+1,dp);
        }
        
        int case1=f(s,t,ind-1,ind2,0,dp);
        int case2=f(s,t,ind,ind2-1,0,dp);
        return dp[ind][ind2][count]=Math.max(same,Math.max(case1,case2));
        
    }