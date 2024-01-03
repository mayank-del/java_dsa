class Pair{
    int data;
    boolean status;
    Pair(int data, boolean status){
        this.data=data;
        this.status=status;
    }
}

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();

        Pair p[]=new Pair[nums.length];
        for(int i=0;i<nums.length;i++){
            p[i]=new Pair(nums[i],false);
        }
        while(true){
            int i=0;
            HashSet<Integer> h=new HashSet<>();
            while(i<p.length){
                if(!h.contains(p[i].data) && p[i].status==false){
                    h.add(p[i].data);
                    p[i].status=true;
                }
                i++;
            }
            List<Integer> l=new ArrayList<>();

            for(Integer it:h){
                l.add(it);
            }
            Collections.sort(l);
            list.add(l);

            //now check for done
            boolean done =true;
            for(Pair pt:p){
                if(pt.status==false){
                    done=false;
                }
            }

            if(done){
                break;
            }

        }
        return list;
    }
}