class Solution {
    public int characterReplacement(String s, int k) {

        int lt=-1,rt=-1;
        int len=0;
        int n=s.length();
        HashMap<Character,Integer> h=new HashMap<>();
        while(true){
            boolean f1=false,f2=false;
            int maxFreq=0;
            while(rt<n-1){
                rt++;
                f1=true;
                char ch=s.charAt(rt);
                h.put(ch,h.getOrDefault(ch,0)+1);
                maxFreq=Math.max(maxFreq,h.get(ch));
                int currSize=rt-lt;
                if((currSize-maxFreq)>k)break;

                len=Math.max(len,rt-lt);
            }
            while(lt<rt){
                lt++;
                f2=true;
                char ch=s.charAt(lt);
                h.put(ch,h.get(ch)-1);
                maxFreq=0;
                for(Character c:h.keySet()){
                    maxFreq=Math.max(maxFreq,h.get(c));
                }
                if(h.get(ch)==0){
                    h.remove(ch);
                    //break;
                }
                int currSize=rt-lt;
                if((currSize-maxFreq)<=k)break;
            }

            if(!f1 &&!f2) break;
        }

        return len;
    }
}