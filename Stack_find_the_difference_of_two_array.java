class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1=new HashSet<>();
        HashSet<Integer> set2=new HashSet<>();

        for(Integer it : nums1){
            set1.add(it);
        }
        for(Integer it : nums2){
            set2.add(it);
        }
        List<List<Integer>> list=new ArrayList<>();

        for(int i=0;i<2;i++){
            list.add(new ArrayList<>());
        }

        for(Integer it : set1){
            if(!set2.contains(it)){
                list.get(0).add(it);
            }
        }

        for(Integer it : set2){
            if(!set1.contains(it)){
                list.get(1).add(it);
            }
        }

        return list;
    }
}