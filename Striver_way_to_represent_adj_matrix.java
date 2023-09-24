public class Striver_way_to_represent_adj_matrix {
    public static void main(String[] args) {
        int n=3,m=3;

        int adj[][]=new int[n+1][n+1];

        
        adj[1][2]=1;
        adj[2][1]=1;

        adj[2][3]=1;
        adj[3][2]=1;

        adj[1][3]=1;
        adj[3][1]=1;

    }
}
