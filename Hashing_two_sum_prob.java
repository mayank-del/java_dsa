import java.util.HashMap;
import java.util.Map;

public class Hashing_two_sum_prob {
    public static void main(String[] args) {
        int n[]={2,6,5,8,11};
        int sum=14;
        int res[]=new int[2];

        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<n.length;i++){
            if(map.containsKey(sum-n[i])){
                res[0]=map.get(sum-n[i]);
                res[1]=i;
                return;
            }
            map.put(n[i], i);
        }
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}
