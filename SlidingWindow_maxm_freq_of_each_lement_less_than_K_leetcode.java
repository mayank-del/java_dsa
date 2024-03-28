import java.util.HashMap;
class SlidingWindow_maxm_freq_of_each_lement_less_than_K_leetcode{
    public static void main(String args[]){
        int nums[]={1,2,3,1,2,3,1,2};
        int k=2;
            HashMap<Integer,Integer> h=new HashMap<>();
        int n=nums.length;
        int len=0;
        int left=-1; int right=-1;
        while(true){
            boolean first=false, sec=false;
            

            while(right<n-1){
                first=true;
                right++;

                h.put(nums[right],h.getOrDefault(nums[right],0)+1);
                if(h.get(nums[right])<=k){
                    len=Math.max(len,right-left);
                }else{
                    break;
                }
   
            }
            while(left<right){
                sec=true;
                left++;
  

                h.put(nums[left],h.get(nums[left])-1);
                if(h.get(nums[left])==0){
                    h.remove(nums[left]);
                }
                if(!h.containsKey(nums[right]) || h.get(nums[right])<=k){
                    break;
                }
                
            }

            if(first==false && sec==false){
                break;
            }
        }
       System.out.println(len);
    }
}