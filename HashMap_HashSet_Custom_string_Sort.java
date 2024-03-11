class Solution {
    public String customSortString(String order, String s) {
        
        //Prio p[]=new Prio[order.length()];
        HashMap<Character,Integer> h=new HashMap<>();
        
        for(Character c:s.toCharArray()){
            //p[i++]=new Prio(c,i);
            //h.put(c,i);
            h.put(c,h.getOrDefault(c,0)+1);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<order.length();i++){
            char c=order.charAt(i);
            if(h.containsKey(c)){
                int it=h.get(c);
                while(it!=0){
                    sb.append(c);
                    it--;
                }
            }
        }
        HashSet<Character> set=new HashSet<>();
        for(Character c:order.toCharArray()){
            set.add(c);
        }
        for(Character c:h.keySet()){
            //char c=order.charAt(i);
            if(!set.contains(c)){
                int it=h.get(c);
                while(it!=0){
                    sb.append(c);
                    it--;
                }
            }
        }
        s=sb.toString();
        return s;
    }
}