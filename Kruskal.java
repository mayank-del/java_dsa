//To find minm spanning tree
import java.util.ArrayList;
class Edge{
    int startVertex;
    int endVertex;
    int weight;

    public Edge(int start,int end,int weight){
        this.startVertex=start;
        this.endVertex=end;
        this.weight=weight;
}
}


class Kruskal{
    public static void main(String[] args) {
        int vertex=5;
        /* int [][] matrix=new int[vertex+1][vertex+1]; */

        ArrayList<Edge> edgeList=new ArrayList<Edge>();

        edgeList.add(new Edge(1,4,2));
        edgeList.add(new Edge(4,2,15));
        edgeList.add(new Edge(2,5,8));
        edgeList.add(new Edge(3,5,6));
        edgeList.add(new Edge(3,1,10));
        edgeList.add(new Edge(3,4,5));

        for(int p=0;p<edgeList.size();p++){   //not related to kruskal

            Edge currentEdge=edgeList.get(p);
            int startVertex=currentEdge.startVertex;
            int endVertex=currentEdge.endVertex;
            int wt=currentEdge.weight;

            System.out.println(startVertex +" "+endVertex+" "+wt);


        }
        for(int p=0;p<edgeList.size()-1;p++){   //sorting array
            for(int j=0;j<edgeList.size()-p-1;j++){
                Edge CurrentEdge=edgeList.get(j);
                Edge NextEdge=edgeList.get(j+1);

                if(CurrentEdge.weight>NextEdge.weight){
                    int tempWt=CurrentEdge.weight;
                    CurrentEdge.weight=NextEdge.weight;
                    NextEdge.weight=tempWt;

                    int tempStart=CurrentEdge.startVertex;
                    CurrentEdge.startVertex=NextEdge.startVertex;
                    NextEdge.startVertex=tempStart;

                    int tempEnd=CurrentEdge.endVertex;
                    CurrentEdge.endVertex=NextEdge.endVertex;
                    NextEdge.endVertex=tempEnd;


                }
            }


        }
        System.out.println("Sorted");
        for(int p=0;p<edgeList.size();p++){

            Edge currentEdge=edgeList.get(p);
            int startVertex=currentEdge.startVertex;
            int endVertex=currentEdge.endVertex;
            int wt=currentEdge.weight;

            System.out.println(startVertex +" "+endVertex+" "+wt);


        }

        int visited[]=new int[]{0,0,0,0,0}; // Declaring array literal
        int weightSum=0;
        for(int i=0;i<vertex;i++){
            Edge currentEdge=edgeList.get(i);

             if(visited[currentEdge.startVertex-1]==0 || visited[currentEdge.endVertex-1]==0){
                visited[currentEdge.startVertex-1]=1;
                visited[currentEdge.endVertex-1]=1;
                weightSum+=currentEdge.weight; 
            }
        }

        System.out.println("Minimum Spanning Wt of tree is:"+weightSum);

    }
}