import java.util.ArrayList;
//import javax.swing.text.html.HTMLDocument.Iterator;
import java.util.Iterator;

/* For implementing bfs, we use queue data structure.consider from {a,b,c,d,e,f} nodes
we started from a , then our input would be  vertices and adjancy list(no of element directly connected to taht element)
  */

public class Bfs {
    int v;
    ArrayList<Integer> adj[];//arrayList is predefined in java for dynamic array (DMA).
    Bfs(int no_of_vertices){
        v=no_of_vertices;
        adj=new ArrayList[no_of_vertices];
        for(int i=0;i<no_of_vertices;i++){
            adj[i]=new ArrayList<>();//every arrayList is list itself
        }
    }
    void edge(int x,int y){//edge always occurs between two vertices x and y
        adj[x].add(y);//add those element which are related to x
    }
    void bfs(int sourceVert){
        boolean[] visited=new boolean[v];
        ArrayList<Integer> a1=new ArrayList<Integer>();

        visited[sourceVert]=true;
        a1.add(sourceVert);
        while(!a1.isEmpty()){
            sourceVert=a1.remove(0);
            System.out.print(sourceVert+" ");
            Iterator i=adj[sourceVert].iterator();//to check whether some more vertices related to it or not.
            while(i.hasNext()){
                int n=(int)i.next();
                if(!visited[n]){
                    visited[n]=true;
                    a1.add(n);
                }
            }
        }
    }
    public static void main(String[] args) {
        Bfs b1=new Bfs(6);

        b1.edge(0,1);
        b1.edge(0,2);
        b1.edge(0,5);
        b1.edge(1,0);
        b1.edge(1,2);
        b1.edge(2,0);
        b1.edge(2,1);
        b1.edge(2,3);
        b1.edge(2,4);
        b1.edge(3,2);
        b1.edge(4,2);
        b1.edge(4,5);
        b1.edge(5,0);
        b1.edge(5,4);

        b1.bfs(0);
    }
}
