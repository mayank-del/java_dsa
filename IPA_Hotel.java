import java.util.*;
class Hotel{
    private int id;
    private String name;


    public Hotel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

class IPA_Hotel{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
            

        ArrayList<Hotel> arr=new ArrayList<>();

        for(int i=0;i<3;i++){
            System.out.println("Give inputs");
            int id=sc.nextInt();sc.nextLine();
            String name=sc.nextLine();

            Hotel h=new Hotel(id,name);

            arr.add(h);
        }
        ArrayList<Hotel>  res=updateNames(arr);
        for(Hotel h:res){
            System.out.println(h.getId());
            System.out.println(h.getName());
            System.out.println();
        }
    }

    public static ArrayList<Hotel> updateNames(ArrayList<Hotel> arr){
        int i=0;
        for(Hotel h:arr){
            if(h.getName().length()<3){
                //arr.set(i,new Hotel(h.getId(),"Name_is_smaller_than_expected_please_change_it"));
                h.setName("Name_is_smaller_than_expected_please_change_it");
            }
            i++;
        }
        return arr;
    }
}



/* 
Differences Between setName and arr.set()
setName Method:

This method changes the name attribute of an existing Hotel object.
It directly modifies the state of the Hotel instance that is already in the ArrayList.
The reference to the Hotel object in the list remains the same; only the object's internal state (the name field) is changed.
arr.set() Method:

This method replaces the Hotel object at a specific index in the ArrayList with a new Hotel object.
It does not modify the existing object but creates a new Hotel instance and updates the reference in the ArrayList to point to this new instance.
The reference in the list changes from the old Hotel object to the new one.
Example Demonstration
Let's look at the provided code with the two different ways to update the names:

Using setName:

public static ArrayList<Hotel> updateNames(ArrayList<Hotel> arr){
    for(Hotel h : arr){
        if(h.getName().length() < 3){
            h.setName("Name_is_smaller_than_expected_please_change_it");
        }
    }
    return arr;
}
Using arr.set():

public static ArrayList<Hotel> updateNames(ArrayList<Hotel> arr){
    int i = 0;
    for(Hotel h : arr){
        if(h.getName().length() < 3){
            arr.set(i, new Hotel(h.getId(), "Name_is_smaller_than_expected_please_change_it"));
        }
        i++;
    }
    return arr;
}
Practical Differences
Performance:

setName modifies the existing object in place, which can be more efficient since 
it avoids creating a new object.
arr.set() creates a new object and updates the list, which involves additional 
overhead for object creation and garbage collection.
Behavior with Listeners/References:

If other parts of your code hold references to the Hotel objects in the ArrayList, 
using setName will reflect the changes in all references.
Using arr.set() replaces the object in the list, which means that any other 
references to the original object will not see the name change.

 */