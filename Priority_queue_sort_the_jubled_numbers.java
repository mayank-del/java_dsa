import java.util.PriorityQueue;

class Pair{
    int num;
    int val;
    int index;

    Pair(int num , int val,int index){
        this.num=num;
        this.val=val;
        this.index=index;
    }
}
class Priority_queue_sort_the_jubled_numbers {
  public int[] sortJumbled(int[] mapping, int[] nums) {
    PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
        if(a.val==b.val) return a.index-b.index;
        else
            return a.val-b.val;
        
        });
    for(int i =0;i<nums.length;i++){
        StringBuilder sb=new StringBuilder(nums[i]+"");
        StringBuilder value=new StringBuilder();
        for(int j=0;j<sb.length();j++){
            value.append(mapping[sb.charAt(j)-'0']+"");
        }
        int numb=Integer.parseInt(sb.toString());
        int vals=Integer.parseInt(value.toString());

        pq.add(new Pair(numb,vals,i));


    }

    int res[]=new int[nums.length];
    int i=0;
    while(!pq.isEmpty()){
        Pair pr=pq.remove();
        res[i++]=pr.num;
    }

    return res;
  }
}


