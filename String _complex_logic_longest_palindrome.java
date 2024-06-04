class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> h=new HashMap<>();
        for(char c:s.toCharArray()){
            h.put(c,h.getOrDefault(c,0)+1);
        }
        int cnt=0;
        boolean odd=false;
        for(char it:h.keySet()){
            if(h.get(it)%2==0 )cnt+=h.get(it);
            else if(h.get(it)%2!=0 &&h.get(it)==1 && odd==false){
                odd =true;
                cnt++;
            }
            else if(h.get(it)%2!=0 &&h.get(it)!=1){
                if(odd){
                    cnt+=(h.get(it)-1);
                }else{
                    odd=true;
                    cnt+=(h.get(it));
                }
            }

        }

        return cnt;
    }
}