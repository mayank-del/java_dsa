class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len=0;
        int r=-1;
        int l=-1;
        HashMap<Character,Integer> h=new HashMap<>();
        while(true){
            //acquire
            boolean f1=false;
            boolean f2=false;
            while(r<s.length()-1){
                f1=true;
                r++;
                char ch=s.charAt(r);
                h.put(ch,h.getOrDefault(ch,0)+1);
                if(h.get(ch)==2){
                    break;
                }else{
                    len=Math.max(len,r-l);
                }
            }

            //release
            while(l<r){
                f2=true;
                l++;
                char ch=s.charAt(l);
                h.put(ch,h.get(ch)-1);

                if(h.get(ch)==1){
                    break;
                }
            }

            if(f1==false && f2==false) break;
        }


        return len;
}
}