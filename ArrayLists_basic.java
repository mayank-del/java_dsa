import java.util.ArrayList;
import java.util.Collections;

public class ArrayLists_basic {
    public static void main(String[] args) {
        ArrayList<Integer> l1=new ArrayList<Integer>();
        /* String ArrayList 
         * ArrayList<String> s= new ArrayList<String>()
         * 
        */
       //ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(101.89757,21.879759,101.8975,101.8976,101.89,32,54,2,64,2,6,4));
        /* Boolean ArrayList
         * ArrayList<Boolean> b=new ArrayList<>()
         */
            //Add OPeration
        System.out.println("add methods");
            l1.add(7);
            l1.add(67);
            l1.add(6);
            l1.add(8);
            System.out.println(l1);

            //Get List
            System.out.println("Get element by index");
           int i= l1.get(0);//index get stored here
            System.out.println(i);


            //Add in any desired index
            System.out.println("Add in any desired index");
            l1.add(1,26);
            System.out.println(l1);

            //Update ArrayList by passing index and its updated value.
            System.out.println("update List by set method");
            l1.set(3,48);
            System.out.println(l1);

            //Delete Element
            System.out.println("Delete by remove method(by a index)");
            l1.remove(0);
            System.out.println(l1);

            //Size of list
            System.out.println("Size of List");
            int s=l1.size();
            System.out.println(s);

            //loops
            System.out.println("Looping th list");
            for(int z=0;z<l1.size();z++){
                System.out.println(l1.get(z)+" ");
            }

            //Sort
            System.out.println("sorting the list");
            Collections.sort(l1);//only works for arryalist not for array 
            System.out.println(l1);
        }
            
}
