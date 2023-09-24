import java.util.ArrayList;

public class Striver_way_to_represent_graph_arrayList {
    public static void main(String[] args) {
        //undirected graph, we will create arrayList of arrayList, and wee will store neighbours of each element in their arrayList,space complexity is O(2m), i.e. twice the edge
        int n=3,m=3;

        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<Integer>());

        }
        
        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(1).add(3);
        adj.get(3).add(1);

        
    
        for(int i=0;i<n;i++){
            for(int j=0;j<adj.get(i).size();j++){
                System.out.println(adj.get(i).get(j));
            }
            System.out.println(); 
        }
    }
}
