// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import java.util.Collections;
class HelloWorld {
    public static void main(String[] args) {
  
        ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(4,7,1,4));
        int min=Integer.MAX_VALUE,sum=0;
        
        for(int i=0;i<4-1;i++){
            //arr.add(i+1,(arr.get(i)+arr.get(i+1))/2);
            sum+=Math.abs(arr.get(i)-arr.get(i+1)) * Math.abs(arr.get(i)-arr.get(i+1));
            //arr.remove(i+1);
        }
        int copy=sum;
        for(int i=0;i<4-1;i++){
            copy=sum;
            copy-=(Math.abs(arr.get(i)-arr.get(i+1)) * Math.abs(arr.get(i)-arr.get(i+1)));
            int mean=(arr.get(i)+arr.get(i+1))/2;
            min=Math.min(min,copy+(Math.abs(arr.get(i)-mean) * Math.abs(mean-arr.get(i)) + Math.abs(arr.get(i+1)-mean) * Math.abs(mean-arr.get(i+1))));
        }
        System.out.println(min);
    }
}