import java.util.Scanner;
import java.util.HashMap;
import java.util.Arrays;


class Pair{
    int first;
    int sec;
    Pair(int first, int sec){
        this.first=first;
        this.sec=sec;
    }
}

class Sort_Array_by_its_Frequency{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter "+i+"th "+"element:");
            int elem=sc.nextInt();
            arr[i]=elem;
        }
        HashMap<Integer,Integer> h=new HashMap<>();
        for(Integer it:arr){
            h.put(it,h.getOrDefault(it,0)+1);
        }
        Pair p[]=new Pair[h.size()]; 
        int ind=0;
        for(Integer it : h.keySet()){
            int val=h.get(it);
            
            p[ind++]=new Pair(it,val);
        }

        Arrays.sort(p,(a,b)->b.sec-a.sec);
        for(int i=0;i<p.length;i++){
            System.out.println(p[i].first+":"+p[i].sec);
        }
        //Arrays.sort(arr, (x,y)-> x - y);
        ind=0;
        for(Pair pr:p){
            int freq=pr.sec;
            for(int i=0;i<freq;i++){
                arr[ind++]=pr.first;
            }
        }

        for(Integer it:arr){
            System.out.print(it+" ");
        }
        
    }
}



//Test cases based solution of problems for tcs nqt


/*  

import java.util.*;
import java.lang.*;
import java.io.*;

class Pair{
    int first;
    int sec;
    Pair(int first, int sec){
        this.first=first;
        this.sec=sec;
    }
}

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc=new Scanner(System.in);
        //System.out.println("Enter size of array:");
        int T=sc.nextInt();
        while(T>0){
            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                //System.out.println("Enter "+i+"th "+"element:");
                int elem=sc.nextInt();
                arr[i]=elem;
            }
            HashMap<Integer,Integer> h=new HashMap<>();
            for(Integer it:arr){
                h.put(it,h.getOrDefault(it,0)+1);
            }
            Pair p[]=new Pair[h.size()]; 
            int ind=0;
            for(Integer it : h.keySet()){
                int val=h.get(it);
                
                p[ind++]=new Pair(it,val);
            }
    
            Arrays.sort(p,(a,b)->b.sec-a.sec);
            
            //Arrays.sort(arr, (x,y)-> x - y);
            ind=0;
            for(Pair pr:p){
                int freq=pr.sec;
                for(int i=0;i<freq;i++){
                    arr[ind++]=pr.first;
                }
            }
            
            for(Integer it:arr){
                System.out.print(it+" ");
            }
            System.out.println();
        T--;
        }
	}
}

*/