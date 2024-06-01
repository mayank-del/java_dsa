class Solution {
    public static String oddEven(String s) {
        // code here
        HashMap<Character,Integer> h=new HashMap<>();
        HashMap<Character,Integer> h2=new HashMap<>();
        for(char ch:s.toCharArray()){
            h.put(ch,h.getOrDefault(ch,0)+1);
        }
        int i=1;
        for(char ch:s.toCharArray()){
            if(!h2.containsKey(ch)){
                h2.put(ch,i++);
            }
        }
        
        int x=0,y=0;
        
        for(char ch:h2.keySet()){
            if(((ch-'a')+1)%2==0 && h.get(ch)%2==0){
                x++;
            }else if(((ch-'a')+1)%2==1 && h.get(ch)%2==1){
                y++;
            }
        }
        
        if((x+y)%2==0){
            return "EVEN";
        }else{
            return "ODD";
        }
    }
}