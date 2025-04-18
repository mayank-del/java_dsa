class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int rem=0, sum=0, cnt=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            rem=sum%k;
            if(rem<0){
                rem+=k;
            }
            if(map.containsKey(rem)){
                cnt+=map.get(rem);
            }
            map.put(rem,map.getOrDefault(rem,0)+1);

        }
        return cnt;
    }
}
