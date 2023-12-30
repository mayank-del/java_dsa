class Solution {
    public boolean makeEqual(String[] words) {
        int n=words.length;

        HashMap<Character,Integer> h=new HashMap<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<words[i].length();j++){
                char ch=words[i].charAt(j);
                h.put(ch,h.getOrDefault(ch,0)+1);
            }
        }


        for(Character ch:h.keySet()){
            if(h.get(ch)%n==0){
                continue;
            }else{
                return false;
            }
        }
        return true;

    }
}