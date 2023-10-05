class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer,Integer> h=new HashMap<>();

        for(Integer it :nums){
            h.put(it,h.getOrDefault(it,0)+1);
        }
        int keyMin=Integer.MAX_VALUE;
        int valMax=Integer.MIN_VALUE;
        for(Integer it : h.keySet()){
            if(it%2==0 && h.get(it)>=valMax ){
                if(h.get(it)==valMax && it>keyMin) continue;

                keyMin=it;
                valMax=h.get(it);
            }
        }
        if(keyMin==Integer.MAX_VALUE) return -1;
        return keyMin;

    }
}