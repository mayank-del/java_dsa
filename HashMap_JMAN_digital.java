// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.HashMap;
import java.util.ArrayList;

class HelloWorld {
    public static void main(String[] args) {
        String a[]={"rio","rio","ben","rio","cha","ben","rio","cha","ben"};
        HashMap<String,Integer> h=new HashMap<>();
        int k=2;
        ArrayList<String> str=new ArrayList<>();
        for(int i=0;i<a.length;i++){
            if(h.containsKey(a[i]) && h.get(a[i])<k){
                str.add("Accepted");
                h.put(a[i],h.getOrDefault(a[i],0)+1);
            }else if(!h.containsKey(a[i])){
                str.add("Accepted");
                h.put(a[i],h.getOrDefault(a[i],0)+1);
            }else{
                str.add("Rejected");
            }
        }
        for(String s : str){
            System.out.println(s);
        }
        
    }
}