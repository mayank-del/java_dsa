import java.util.ArrayList;

public class Graph_number_of_provinces {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i=0;i<adj.size();i++){
            list.add(new ArrayList<>());
        }
        
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.size();j++){
                if(adj.get(i).get(j)==1){
                    list.get(i).add(j);
                }
            }
        }
        int cnt=0;
        boolean vis[]=new boolean[list.size()];
        for(int i=0;i<list.size();i++){
            if(!vis[i]){
                cnt++;
                dfsFun(i,vis,list);
            }
        }
        return cnt;
        
    }
    static void dfsFun(int node,boolean vis[],ArrayList<ArrayList<Integer>> list){
        vis[node]=true;
        
        //res.add(node)
        
        for(Integer i:list.get(node)){
            if(!vis[i]){
                dfsFun(i,vis,list);
            }
        }
    }
}
