class Pair{
    int dest; int wt;
    Pair(int dest,int wt){
        this.dest=dest;
        this.wt=wt;
        
    }
}
//User function Template for Java
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		ArrayList<ArrayList<Pair>> arr=new ArrayList<>();
		
		for(int i=0;i<N;i++){
		    arr.add(new ArrayList<Pair>());
		}
		
		
		   for(int j=0;j<M;j++){
		        arr.get(edges[j][0]).add(new Pair(edges[j][1],edges[j][2]));
		    } 
		
		
		int dist[]=new int[N];
		int vis[]=new int[N];
		PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.wt-b.wt);
	    //Queue<Pair> q=new LinkedList<>();
	    //Stack<Integer> st=new Stack<>();
	    
		for(int i=1;i<N;i++){
		    dist[i]=(int)1e9;
		}
		
		pq.add(new Pair(0,0));
		
		    
		    /*for(int i=0;i<N;i++){
		        if(vis[i]==0){
		            topoSort(arr,vis,dist,st,i);
		        }
		    }*/
		
		while(!pq.isEmpty()){
		    Pair n=pq.remove();
		    int node=n.dest;
		    int prevWt=n.wt;
		    
		    for(Pair p:arr.get(node)){
		        int v=p.dest;
		        int wt=p.wt;
		        
		        if(prevWt+wt<dist[v]){
		            dist[v]=prevWt+wt;
		            pq.add(new Pair(v,dist[v]));
		        }
		    }
		    
		}
		for(int i=0;i<N;i++) if(dist[i]==(int)1e9) dist[i]=-1;
		
		return dist;
	}
	private void topoSort(ArrayList<ArrayList<Pair>> adj,int vis[],int dist[],Stack<Integer> st,int node){
	    vis[node]=1;
	    for(Pair p:adj.get(node)){
	        int v=p.dest;
	        if(vis[v]==0)
	            topoSort(adj,vis,dist,st,v);
	    }
	    st.add(node);
	}
}