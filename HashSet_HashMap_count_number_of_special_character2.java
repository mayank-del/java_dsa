class Solution {
    public int numberOfSpecialChars(String word) {
        char cap[]=new char[26];
        char small[]=new char[26];
        HashSet<Character> set=new HashSet<>();
        HashMap<Character,Integer> map=new HashMap<>();
        
        int cnt=0;
        int i=0;
        for(char ch:word.toCharArray()){
            
            if(ch-'A'<=25 && !map.containsKey(ch))map.put(ch,i);
            else if(ch-'A'>25) map.put(ch,i);
                i++;
        }
        
        for(char ch:word.toCharArray()){
            if(ch-'A'<=25 && !set.contains(ch) ){
               if(map.containsKey(Character.toLowerCase(ch)) ){
                   set.add(ch);
                   if(map.get(Character.toLowerCase(ch)) < map.get(ch) )cnt++;
               } 
            }
        }
        
        return cnt;
    }
}