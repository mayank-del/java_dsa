/* A sequence of numbers is called arithmetic if it consists of at least two 
elements, and the difference between every two consecutive elements is the same.
 More formally, a sequence s is arithmetic if and only if 
 s[i+1] - s[i] == s[1] - s[0] for all valid i.

For example, these are arithmetic sequences:

1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
The following sequence is not arithmetic:

1, 1, 2, 5, 7
You are given an array of n integers, nums, and two arrays of m integers each, 
l and r, representing the m range queries, where the ith query is the 
range [l[i], r[i]]. All the arrays are 0-indexed.

Return a list of boolean elements answer, where answer[i] is true if the 
subarray nums[l[i]], nums[l[i]+1], ... , nums[r[i]] can be rearranged to form
an arithmetic sequence, and false otherwise. */

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        List<Boolean> res=new ArrayList<>();

        for(int i=0;i<l.length;i++){
            ArrayList<Integer> arr=new ArrayList<>();

            for(int q=l[i];q<=r[i];q++){
                arr.add(nums[q]);
            }
            Collections.sort(arr);
            
                int diff=arr.get(0)-arr.get(1);
                for(int j=2;j<arr.size();j++){
                    if(diff!=arr.get(j-1)-arr.get(j)){
                        res.add(false);
                        break;
                    }
                }
            if(res.size()-1!=i)
                res.add(true);
        }
        return res;
    }
}