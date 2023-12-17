class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> h=new HashMap<>();
        HashMap<Character,Integer> h2=new HashMap<>();

        for(Character ch:s.toCharArray()){
            h.put(ch,h.getOrDefault(ch,0)+1);
        }
        for(Character ch:t.toCharArray()){
            h2.put(ch,h2.getOrDefault(ch,0)+1);
        }

        if(h.equals(h2)){
            return true;
        }else{
            return false;
        }
    }
}