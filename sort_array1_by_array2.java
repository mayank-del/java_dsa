class Solution {
    public int[] relativeSortArray(int[] A1, int[] A2) {
        HashMap<Integer,Integer> h =new HashMap<>();
        int M=A2.length;
        int N=A1.length;
        for(int i=0;i<M;i++){
            if(!h.containsValue(A2[i]))
                h.put(i,A2[i]);
        }
        
        HashMap<Integer,Integer> h2=new HashMap<>();
        
        for(int i=0;i<N;i++){
            if(!h2.containsKey(A1[i]))
                h2.put(A1[i],1);
            else
                h2.put(A1[i],h2.get(A1[i])+1);
        }
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<M;i++){
            if(h2.containsKey(h.get(i))){
            for(int j=0;j<h2.get(h.get(i));j++){//to print number of times , it occurs
                arr.add(h.get(i));
               
            }
            h2.remove(h.get(i));
                
            }
        }
        
        int len=0;
        for(Integer x:h2.keySet()){
            for(int i=0;i<h2.get(x);i++){
                //arr.add(x);
                len++;
            }
        }
        int unsorted_remaining_data[]=new int[len];
        int it=0;
        for(Integer x:h2.keySet()){
            for(int i=0;i<h2.get(x);i++){
                unsorted_remaining_data[it]=x;   
                it++;
            }
        }
        Arrays.sort(unsorted_remaining_data);
        int a[]=new int[arr.size()+len];
        for(int i=0;i<arr.size();i++){
            a[i]=arr.get(i);
        }
        for(int i=0;i<len;i++){
            a[arr.size()+i]=unsorted_remaining_data[i];
        }
        return a;
    }
}