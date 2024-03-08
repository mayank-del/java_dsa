class Solution {
    public int maxTurbulenceSize(int[] arr) {
        
        int max_len=2;
        if(arr.length==1) return 1;
        HashSet<Integer> h=new HashSet<>();
        h.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            h.add(arr[i]);
        }
        if(h.size()==1)return 1;
        boolean ilti=false,pilti=false;
        int start=0;
        for(int i=1;i<arr.length-1;i++){
            if(arr[i-1]<arr[i] && arr[i]>arr[i+1]){
                max_len=Math.max(max_len,((i+1)-start)+1);
            }else if(arr[i-1]>arr[i] && arr[i]<arr[i+1]){
                max_len=Math.max(max_len,((i+1)-start)+1);
            }else{
                start=i;
                continue;
            }


        }
        return max_len;

    }
}