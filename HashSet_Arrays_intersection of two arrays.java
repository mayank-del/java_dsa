class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> arr=new ArrayList<>();

        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            set.add(nums1[i]);
        }
        int j=0;
        for(int i=0;i<nums2.length;i++){
            if(set.contains(nums2[i])){
                arr.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }

        int res[]=new int[arr.size()];

        for(Integer it:arr){
            res[j++]=it;
        }

        return res;
    }
}