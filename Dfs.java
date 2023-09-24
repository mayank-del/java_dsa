import java.util.ArrayList;

import java.util.Stack;

public class Dfs {
    int v;
    ArrayList<Integer>[] adj;
    Dfs(int no_of_vertices){
        v=no_of_vertices;
        adj=new ArrayList[no_of_vertices];
        for(int i=0; i<no_of_vertices;i++){
            adj[i]=new ArrayList<>();
        }
    }
    void edge(int x,int y){
        adj[x].add(y);
    }
    void dfs(int sourceVert){
        boolean[] visited=new boolean[v];
        Stack<Integer> s1=new Stack<>();
        s1.push(sourceVert);

        int node;
        while(!s1.empty()){
            sourceVert=s1.peek();
            s1.pop();
        
        for(int i=0;i<adj[sourceVert].size();i++){
            node=adj[sourceVert].get(i);
            if(!visited[node]){
                s1.push(node);
            }
        }
        if(visited[sourceVert]==false){
            System.out.print(sourceVert + " ");
            visited[sourceVert]=true;
        }}
    }
    public static void main(String[] args) {
        Dfs b1=new Dfs(6);

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

        b1.dfs(0);
    }
}
