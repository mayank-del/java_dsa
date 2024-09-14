// Online Java Compiler
// Use this editor to write, compile and run your Java code online
//if number is palindrome then we will print it is odd or even
import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> arr=new ArrayList<>();
        int num=sc.nextInt();
        fibo(0,num,arr);
        System.out.println(arr);
        
        
    }
    public static void fibo(int num,int end, ArrayList<Integer> arr){
        if(arr.size()==end) return;
        if(num==0 || num==1){
            arr.add(num);
        }
        else if(num==2){
            arr.add(1);
        }
        else{
            arr.add(arr.get(num-1)+arr.get(num-2));
        }
        fibo(num + 1, end, arr);
        
    }
}

/* 
 * This means that dog is a reference variable of type Animal, but it is actually referring to an object of type Dog.
 * 
 */

 /* 
  * 
  JDK
The Java Development Kit is a development environment for building Java applications, applets, and components. 
It includes tools for developing, testing, and debugging Java programs. 

JRE
The Java Runtime Environment is a software layer that provides the resources needed for Java programs to run. 
It includes the Java Virtual Machine (JVM), class libraries, and other supporting files. 

JVM
The Java Virtual Machine is the foundation of the Java programming language. It allows Java programs to run on any device or
operating system, and manages and optimizes program memory. 
Jvm is am interpreter thst is responsible to run run java program line by line.

  */