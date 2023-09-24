class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer,Integer> h=new HashMap<>();
        int max=-1;
        for(int i=0;i<arr.length;i++){
            h.put(arr[i],h.getOrDefault(arr[i],0)+1);
        }
        for(Integer it : h.keySet()){
            if(h.get(it)==it){
                max=Math.max(max,it);
            }
        }
        return max;
    }
}