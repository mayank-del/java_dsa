class Solution {
    public int countWords(String[] words1, String[] words2) {

        HashMap<String, Integer> map=new HashMap<>();
        HashMap<String, Integer> map2=new HashMap<>();
        
        for(String word : words1){
            map.put(word,map.getOrDefault(word,0)+1);
        }

        for(String word : words2){
            map2.put(word,map2.getOrDefault(word,0)+1);
        }

        int cnt=0;

        for(String st:map.keySet()){
            if(map2.containsKey(st) && map.get(st)==1 && map2.get(st)==1){
                cnt++;
            }
        }
        return cnt;
    }
}