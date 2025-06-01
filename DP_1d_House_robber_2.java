class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];

        int n=nums.length;
        int dp[]=new int[n-1];
        int dp1[]=new int[n-1];
        ArrayList<Integer> t1=new ArrayList<>();
        ArrayList<Integer> t2=new ArrayList<>();
        //int t2[]=new int[n-1];
        
        for(int i=0;i<n;i++){
            if(i!=0){
                t1.add(nums[i]);
            }if(i!=n-1){
                t2.add(nums[i]);
            }
        }

        Arrays.fill(dp,-1);
        Arrays.fill(dp1,-1);
        int res=Math.max(f(t1,0,dp),f(t2,0,dp1));
        return res;
    }
    public int f(ArrayList<Integer> nums,int ind,int dp[]){
        if(ind>=nums.size()) return 0;
        if(dp[ind]!=-1) return dp[ind];
        if(ind==nums.size()-1) return nums.get(ind);
        int pick=nums.get(ind)+f(nums,ind+2,dp);
        int not_pk=0+f(nums,ind+1,dp);

        return dp[ind]=Math.max(pick,not_pk);
    }
}
