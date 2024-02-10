class Pair{
    int freq;
    int ind;
    Pair(int freq,int ind){
        this.freq=freq;
        this.ind=ind;
    }
}

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Pair> h=new HashMap<>();
        int ind=0;
        for(Character ch :s.toCharArray()){
            Pair pair = h.get(ch);
            if (pair == null) {
                h.put(ch, new Pair(1, ind));
            } else {
                h.put(ch, new Pair(pair.freq + 1, ind));
            }
            ind++;
        }
        for(Character ch :s.toCharArray()){
            if(h.get(ch).freq==1){
                return h.get(ch).ind;            }
        }

        return -1;
    }
}