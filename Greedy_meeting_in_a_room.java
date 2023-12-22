//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N; 
            N = Integer.parseInt(br.readLine());
            
            
            int[] S = IntArray.input(br, N);
            
            
            int[] F = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.maxMeetings(N, S, F);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends

class Pair{
    int x,y,meet_no;
    Pair(int x,int y,int meet_no){
        this.x=x;
        this.y=y;
        this.meet_no=meet_no;
        
    }
}
class Solution {
    public static ArrayList<Integer> maxMeetings(int N, int[] s, int[] f) {
        // code here
        int cnt=0, j=0;
        Pair[] p=new Pair[N];
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<N;i++){
            p[i]=new Pair(s[i],f[i],i+1);
        }
        
       /* Arrays.sort(p,(a,b)->{
            if(a.y!=b.y){
                if(a.y>b.y){
                    return 1;
                }else {
                    return -1;
                }
            }else{
                if(a.x>b.x){
                    return 1;
                }else {
                    return -1;
                }
            }
            
        });*/
        Arrays.sort(p,(a,b)->a.y==b.y?a.x-b.x:a.y-b.y);
        //list.add(j+1);
        int initial_val_of_f=-1;
        for(int i=0;i<N;i++){
            if(initial_val_of_f<p[i].x){
                initial_val_of_f=p[i].y;
                list.add(p[i].meet_no);
            }
        }
        Collections.sort(list);
        return list;
    }
}
        
