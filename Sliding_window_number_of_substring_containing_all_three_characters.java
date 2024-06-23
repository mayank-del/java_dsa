class Solution {
    public int numberOfSubstrings(String s) {
        int seen[]={-1,-1,-1};
        int cnt=0;
        for(int i=0;i<s.length();i++){
            seen[s.charAt(i)-'a']=i;
            if(seen[0]!=-1 && seen[1]!=-1 && seen[2]!=-1 ){
                cnt+=(1+Math.min(Math.min(seen[0],seen[1]),seen[2]));
            }
        }
        return cnt;
    }
}