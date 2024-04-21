class Solution {
    public int numberOfSpecialChars(String word) {
        
        char cap[]=new char[26];
        char small[]=new char[26];
        
        for(char ch:word.toCharArray()){
            if(ch-'a'>=0){
                small[ch-'a']++;
            }else{
                cap[ch-'A']++;
            }
        }
        int cnt=0;
         HashSet<Character> set=new HashSet<>();
        for(char ch:word.toCharArray()){
            if(ch-'A'<=25 && !set.contains(ch) && small[ch-'A']>0){
                set.add(ch);
                cnt++;
            }
        }
        
        return cnt;
    }
}