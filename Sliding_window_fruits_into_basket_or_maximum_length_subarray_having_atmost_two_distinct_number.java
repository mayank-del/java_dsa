class Solution {
    public int totalFruit(int[] fruits) {
        int lt=-1,rt=-1;
        int n=fruits.length;
        HashMap<Integer,Integer> h=new HashMap<>();
        int len=0;
        while(true){
            boolean f1=false,f2=false;

            //acquire
            while(rt<n-1){
                rt++;
                f1=true;

                h.put(fruits[rt],h.getOrDefault(fruits[rt],0)+1);
                if(h.size()<=2){
                    len=Math.max(len,rt-lt);
                }else if(h.size()>2){
                    break;
                }

            }
            //release
            while(lt<rt){
                lt++;
                f2=true;

                h.put(fruits[lt],h.get(fruits[lt])-1);
                if(h.get(fruits[lt])==0) h.remove(fruits[lt]);

                if(h.size()<=2) break;
            }

            if(!f1 && !f2){
                break;
            }
        }
        return len;
    }
}