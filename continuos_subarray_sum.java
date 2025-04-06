class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length<2)return false;
        int sum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        for (int i=0;i<nums.length;i++){
            sum+=nums[i];
            int rem=sum%k;
            if(map.containsKey(rem) && i-map.getOrDefault(rem,0)>=2){
                  return true;
            }else if(!map.containsKey(rem)){
                map.put(rem,i);
            }
            //map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        return false;
    }
}