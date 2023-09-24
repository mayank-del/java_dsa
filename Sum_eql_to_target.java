public class Sum_eql_to_target {
    public static void main(String[] args) {
        
        int k=18;
        int nums[]={2,4,3,1,5};
        int n=nums.length;
        
        boolean dp[][]=new boolean[n][k+1];
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }
        dp[0][nums[0]]=true;
        for(int ind=1;ind<n;ind++){
            for(int target=1;target<=k;target++){
                boolean notTake=dp[ind-1][target];
                boolean take=false;

                if(nums[ind]<=target)
                    take=dp[ind-1][target-nums[ind]];

                dp[ind][target] = take | notTake;
            
            }
        }
        System.out.println(dp[n-1][k]);
    }

    /* public static void main(String[] args) {
        int k=15;
        int nums[]={2,4,3,1,5};
        int n=nums.length;
        
        System.out.println(f(nums,k,n-1));
    }
    public static boolean f(int nums[],int target,int index){
        if(target==0){
            return true;
        }if(index==0){
            return (nums[0]==target);
        }
        boolean notTake=f(nums,target,index-1);
        boolean take=true;
        if(nums[index]<=target){
            take=f(nums,target-nums[index],index-1);
        }
        return take | notTake;
    } */
}
