class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l_prod[]=new int[nums.length];
        int r_prod[]=new int[nums.length];
        int res[]=new int[nums.length];
        int prod=1;
        for(int i=0;i<nums.length;i++){
            prod*=nums[i];
            l_prod[i]=prod;
        }
        prod=1;
        //r_prod[n-1]=nums[n-1];
        for(int i=nums.length-1;i>=0;i--){
            prod*=nums[i];
            r_prod[i]=prod;
        }
        for(int i=0;i<nums.length;i++){
            if(i==0){
                res[i]=1*r_prod[i+1];
                continue;
            }if(i==nums.length-1){
                res[i]=1*l_prod[i-1];
                continue;
            }
            res[i]=l_prod[i-1] * r_prod[i+1];

        }
        return res;

    }
}