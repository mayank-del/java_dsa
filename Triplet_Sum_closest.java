class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum=-200000;
        int min=Integer.MAX_VALUE;
        int val=Integer.MAX_VALUE;
        for(int i=0;i<nums.length-1;i++){
            int lt=i+1;
            int rt=nums.length-1;
            for(;lt<rt;){
                sum=nums[i]+nums[lt]+nums[rt];
                if(sum==target){
                    return sum;
                }else if(sum>target){
                    rt--;
                    if(min>Math.abs(target-sum)){
                        min=Math.abs(target-sum);
                        val=sum;
                    }
                }else if(sum<target){
                    lt++;
                    if(min>Math.abs(target-sum)){
                        min=Math.abs(target-sum);
                        val=sum;
                    }
                }
                
            }
        }
        return val;
    }
}