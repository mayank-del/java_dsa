class Solution {
    public int findSpecialInteger(int[] arr) {
        HashMap<Integer,Integer> h=new HashMap<>();

        for(Integer it : arr){
            h.put(it,h.getOrDefault(it,0)+1);
        }

        for(Integer it:h.keySet()){
            if(h.get(it)>(arr.length)/4){
                return it;
            }
        }
        return -1;
    }
}