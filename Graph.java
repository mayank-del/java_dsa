 import java.util.ArrayList;

/*class Edge{
    int startVertex;
    int endVertex;
    int weight;

    public Edge(int start,int end,int weight){
        this.startVertex=start;
        this.endVertex=end;
        this.weight=weight;
    }
}

public class Graph {
    public static void main(String args[]){
        int vertex=5;
        int [][] matrix=new int[vertex+1][vertex+1];

        ArrayList<Edge> edgeList=new ArrayList<Edge>();

        edgeList.add(new Edge(1,4,2));
        edgeList.add(new Edge(4,2,15));
        edgeList.add(new Edge(2,5,8));
        edgeList.add(new Edge(3,5,6));
        edgeList.add(new Edge(3,1,10));
        edgeList.add(new Edge(3,4,5));

    
        for(int i=0;i<edgeList.size();i++){
            Edge currentEdge=edgeList.get(i);
            int startVertex=currentEdge.startVertex;
            int endVertex=currentEdge.endVertex;
            int wt=currentEdge.weight;
            matrix[startVertex][endVertex]=wt;
        }

            //print 2d matrix to check vertex and edges 
            for(int i=1;i<=vertex;i++){
                for(int j=1;j<=vertex;j++){
                    System.out.print(matrix[i][j]+" ");
                }
                System.out.println();
            }

    }
} */

//Striver representation without weighted , it is just for eye-wash

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String[] args) {
        int n=3,m=3;

        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        // edge 1--2
        adj.get(1).add(2);
        adj.get(2).add(1);

        // edge 2--3
        adj.get(2).add(3);
        adj.get(3).add(2);

        //edge 1--3
        adj.get(1).add(3);
        adj.get(3).add(1);

        //if directed edge 4-->3
        adj.get(4).add(3);

        for(int i=0;i<n;i++){
            for(int j=0;j<adj.get(i).size();j++){
                System.out.println(adj.get(i).get(j)+ " ");
            }
            System.out.println();
        }

    }
}


