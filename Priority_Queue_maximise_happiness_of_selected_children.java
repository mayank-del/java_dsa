class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int it:happiness){
            pq.add(it);
        }
        long sum=0;
        int cnt=0;
        int decFactor=0;
        for(;cnt<k;){
            int val=pq.remove()-decFactor;
            if(val<0)val=0;
            sum+=(val);
            cnt++;
            decFactor++;
        }

        return sum;

    }
}