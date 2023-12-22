class Solution {
    public int maxScore(String s) {
        String left="",right="";
        int maxm=Integer.MIN_VALUE;
        for(int i=0;i<s.length()-1;i++){
            left=s.substring(0,i+1);
            right=s.substring(i+1);
            int zero=0,ones=0;

            for(Character ch:left.toCharArray()){
                if(ch=='0'){
                    zero++;
                }
            }

            for(Character ch:right.toCharArray()){
                if(ch=='1'){
                    ones++;
                }
            }

            maxm=Math.max(maxm,ones+zero);
        }
        return maxm;
    }
}