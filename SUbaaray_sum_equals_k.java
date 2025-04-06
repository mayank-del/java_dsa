class Solution {
    public int subarraySum(int[] nums, int k) {
        /*int cnt=0;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            sum+=nums[i];
            if(sum==k)cnt++;
            for(int j=i+1;j<nums.length;j++){
                sum+=nums[j];
                if(sum==k)cnt++;
            }
            sum=0;
        }
        return cnt;*/

        HashMap<Integer,Integer> map=new HashMap<>();
        int cnt=0;int sum=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                cnt+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return cnt;
    }
}