// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.HashMap;
class HelloWorld {
    
    public static void main(String[] args) {
        String str="online java compiler";
    HashMap<Character, Integer> h=new HashMap<>();
    char c[]=str.toCharArray();
    for(Character ch:c){
        h.put(ch,h.getOrDefault(ch,0)+1);
    }
    int cnt=0;
    String res="";
    for(Character ch:h.keySet()){
        if(h.get(ch)==1){
            cnt++;
            res=res+ch+" ";
        }
    }
        //System.out.println(cnt);
        System.out.println(h);
    }
}