import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class CompImp implements Comparator<Integer>{
    public int compare(Integer a1,Integer a2){
        //if(a1%10>a2%10) return 1; 
        if(a1>a2) return 1;

        return -1;
    }
}

public class Comaparator_interface {
    public static void main(String[] args) {
    ArrayList <Integer> values=new ArrayList<Integer>();
    values.add(67766);
    values.add(67897);
    values.add(769);
    values.add(6768);
    values.add(75141);
    values.add(678683);

    Comparator<Integer> com=new CompImp();

    Collections.sort(values,com);

    for(int i : values){
        System.out.println(i);
    }
        
    }
    
}
