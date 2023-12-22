//1st

/* Arrays.sort(arr,(a,b)->a[0]-b[0]);
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    adj.add(new ArrayList<>(Arrays.asList(arr[0][0],arr[0][1]))); */



// 2nd


/* Arrays.sort(arr, (a, b) -> {
            double ratioA = (double) a.value / a.weight;
            double ratioB = (double) b.value / b.weight;
            if (ratioA < ratioB) {
                return 1; // Indicates that 'a' should come after 'b' (descending order).
            } else if (ratioA > ratioB) {
                return -1; // Indicates that 'a' should come before 'b' (descending order).
            } else {
                return 0; // Indicates that 'a' and 'b' are equal in terms of ratio.
            }
        }); */



    //3rd

    /* 
    
    // Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Arrays;
class Pair{
    int x,y,meet_no;
    Pair(int x,int y,int meet_no){
        this.x=x;
        this.y=y;
        this.meet_no=meet_no;
        
    }
}

class HelloWorld {
    public static void main(String[] args) {
        int N=6;
        int s[]={1,3,0,5,8,5};
        int f[]={2,4,6,7,9,9};
        int cnt=0, j=0;
        
        Pair[] p=new Pair[N];
        
        for(int i=0;i<N;i++){
            p[i]=new Pair(s[i],f[i],i+1);
        }
        
        Arrays.sort(p,(a,b)->{
            if(a.y-a.x>b.y-b.x){
                return 1;//a comes after b
            }else if(a.y-a.x==b.y-b.x){
                if(a.x>b.x)
                    return 1;
                else if(a.x==b.x){
                    if(a.meet_no>b.meet_no){
                        return 1;
                    }else {
                        return -1;
                    }
                }else {
                    return -1;
                }
            }else{
                return -1;
            }
        });
        for(Pair pt:p){
            System.out.println("x:"+pt.x);
            System.out.println("y:"+pt.y);
            System.out.println("meet id:"+pt.meet_no);
            
        }
    }
}
    
     */