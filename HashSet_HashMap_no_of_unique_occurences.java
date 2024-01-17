class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> h=new HashMap<>();

        for(Integer it:arr){
            h.put(it,h.getOrDefault(it,0)+1);
        }

        HashSet<Integer> set=new HashSet<>();

        for(Integer it:h.keySet()){
            if(!set.contains(h.get(it))){
                set.add(h.get(it));
            }else{
                return false;
            }
        }
        return true;

    }
}