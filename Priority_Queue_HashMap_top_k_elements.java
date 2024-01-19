class Pair{
    int num;
    int freq;
    
    Pair(int num,int freq){
        this.num=num;
        this.freq=freq;
    }
}

class Solution{
    public static ArrayList<ArrayList<Integer>> kTop(int[] arr, int N, int K) {
            // code here
            HashMap<Integer,Integer> h=new HashMap<>();
            ArrayList<ArrayList<Integer>> res=new ArrayList<>();
            
            
            
            for(int i=0;i<N;i++){
                if(arr[i]!=0)
                    h.put(arr[i],h.getOrDefault(arr[i],0)+1);
                PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
                //@Override
                public int compare(Pair a, Pair b) {
                    if (a.freq - b.freq > 0) {
                        return -1;
                    } else if (a.freq - b.freq < 0) {
                        return 1;
                    } else if (a.freq == b.freq) {
                        return a.num > b.num ? 1 : -1;
                    }
                    return 0;
                        }
                    });
                int j=0;
                for (Integer key : h.keySet()) {
                    pq.add(new Pair(key, h.get(key)));
                }

                ArrayList<Integer> list=new ArrayList<>();
                while(j<K && !pq.isEmpty()){
                    list.add(pq.remove().num);
                    j++;
                }
                res.add(list);
            }
            
            return res;
        }
}