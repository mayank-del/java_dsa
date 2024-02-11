//unoptimsed code

static ArrayList<Integer> recamanSequence(int n){
        // code here
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(0);
        
        for(int i=1;i<=n;i++){
            if(arr.contains(arr.get(i-1)-i)){
                arr.add(arr.get(i-1)+i);
            }else if(arr.get(i-1)-i>0){
                arr.add(arr.get(i-1)-i);
            }else if(arr.get(i-1)-i<0){
                arr.add(arr.get(i-1)+i);
            } 
        }
        
        return arr;
    }

//Optimsed code


import java.util.ArrayList;
import java.util.HashSet;

static ArrayList<Integer> recamanSequence(int n) {
    ArrayList<Integer> arr = new ArrayList<>();
    HashSet<Integer> set = new HashSet<>();
    arr.add(0);
    set.add(0);
    
    for (int i = 1; i < n; i++) {
        int next = arr.get(i - 1) - i;
        if (next < 0 || set.contains(next)) {
            next = arr.get(i - 1) + i;
        }
        arr.add(next);
        set.add(next);
    }
    
    return arr;
}
