class Solution {
    public int[] arrayChange(int[] nums, int[][] oper) {
        ArrayList<Integer> arr=new ArrayList<>();
        for(Integer it:nums){
            arr.add(it);
        }
        for(int i=0;i<oper.length;i++){
            int ind=arr.indexOf(oper[i][0]);
            arr.remove(ind);
            arr.add(ind,oper[i][1]);
            //arr.set(ind,oper[i][1]);
        }
        nums=new int[arr.size()];
        int i=0;
        for(Integer it:arr){
            nums[i++]=it;
        }
        return nums;
    }
}