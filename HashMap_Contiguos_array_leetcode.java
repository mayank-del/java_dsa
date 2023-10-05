class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> h=new HashMap<>();
        
        h.put(0,-1);
        int sum=0,maxm=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                sum+=-1;
            }else if(nums[i]==1){
                sum+=1;
            }
            if(!h.containsKey(sum))
                h.put(sum,i);
            else
                maxm=Math.max(maxm,i-h.get(sum));

        }
        return maxm;

    }
}