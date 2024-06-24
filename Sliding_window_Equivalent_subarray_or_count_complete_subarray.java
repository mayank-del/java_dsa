class Solution {
    public int countCompleteSubarrays(int[] arr) {
        int n=arr.length;
        HashSet<Integer> set = new HashSet<>();
        
        for(int i:arr){
            set.add(i);
        }
        
        int k=set.size();
        int cnt=0;
        HashMap<Integer,Integer> h=new HashMap<>();
        
        int lt=-1,rt=-1;
        while(true){
            boolean f1=false,f2=false;
            while(rt<n-1){
                rt++;
                f1=true;
                h.put(arr[rt],h.getOrDefault(arr[rt],0)+1);
                if(h.size()==k){
                    //to count all sub array from rt pointer to end of array
                    cnt+=(n-rt);
                    break;
                }
                
            }
            
            while(lt<rt){
                lt++;
                f2=true;
                int val=h.get(arr[lt]);
                h.put(arr[lt],val-1);
                if(h.get(arr[lt])==0){
                    h.remove(arr[lt]);
                }
                if(h.size()==k){
                    //to count all sub array from rt pointer to end of array
                    cnt+=(n-rt);
                    
                }
                if(h.size()<k){
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