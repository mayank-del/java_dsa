import java.util.HashMap;
class HelloWorld {
    public static void main(String[] args) {
        HashMap<Character,Integer> h=new HashMap<>();
        String s="polikujmnhytgbvfredcxswqaz";
        String t="aaabcdd";
        for(int i=0;i<t.length();i++){
            h.put(t.charAt(i),h.getOrDefault(t.charAt(i),0)+1);
        }
        String res="";
        for(int i=0;i<s.length();i++){
            if(h.containsKey(s.charAt(i))){
                for(int j=0;j<h.get(s.charAt(i));j++){
                    res+=s.charAt(i);
                }
            }
        }
        System.out.println(res);
    }
}
