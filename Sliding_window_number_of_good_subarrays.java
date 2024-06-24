//Approach 1 time limit exceeded

class Solution {

    public long ncr(int n){
        long res=(n*(n-1))/2;
        return res;
    }
    
    public long countGood(int[] nums, int k) {

        int n=nums.length;
        
        int cnt=0;
        HashMap<Integer,Integer> h=new HashMap<>();
        
        int lt=-1,rt=-1;
        while(true){
            boolean f1=false,f2=false;
            while(rt<n-1){
                rt++;
                f1=true;
                h.put(nums[rt],h.getOrDefault(nums[rt],0)+1);
                long sum=0;

                for(int it:h.keySet()){
                    sum+=ncr(h.get(it));
                }
                if(sum>=k){
                    cnt+=(n-rt);
                    break;
                }
                
            }
            
            while(lt<rt){
                lt++;
                f2=true;
                int val=h.get(nums[lt]);
                h.put(nums[lt],val-1);
                long sum=0;

                for(int it:h.keySet()){
                    sum+=ncr(h.get(it));
                }
                if(sum>=k){
                    cnt+=(n-rt);
                    
                }
                else if(sum<k){
                    break;
                }
                
            }
            
            if(!f1 && !f2){
                break;
            }
            
        }
        
        return cnt;
    }
}

//Approach 2 perfect approach


class Solution {

    public long ncr(int n) {
        if (n < 2) return 0;
        long res = (long) n * (n - 1) / 2;
        return res;
    }
    
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        long cnt = 0;
        HashMap<Integer, Integer> h = new HashMap<>();
        
        int lt = -1, rt = -1;  // Start lt at 0, rt at -1
        long sum = 0;

        while (true) {
            boolean f1 = false, f2 = false;
            while (rt < n - 1) {
                rt++;
                f1 = true;
                h.put(nums[rt], h.getOrDefault(nums[rt], 0) + 1);

                if (h.get(nums[rt]) > 1) {
                    sum -= ncr(h.get(nums[rt]) - 1);
                    sum += ncr(h.get(nums[rt]));
                }

                if (sum >= k) {
                    cnt += (n - rt);
                    break;
                }
            }
            
            while (lt < rt) {
                lt++;
                sum -= ncr(h.get(nums[lt]));
                h.put(nums[lt], h.get(nums[lt]) - 1);

                if (h.get(nums[lt]) > 1) {
                    sum += ncr(h.get(nums[lt]));
                }

                
                f2 = true;

                if (sum >= k) {
                    cnt += (n - rt);
                } else {
                    break;
                }
            }
            
            if (!f1 && !f2) {
                break;
            }
        }
        
        return cnt;
    }

}