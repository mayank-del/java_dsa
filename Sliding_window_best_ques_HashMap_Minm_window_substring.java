class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> h1=new HashMap<>();
        HashMap<Character,Integer> h2=new HashMap<>();

        String ans="";

        int l=-1, r=-1;
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            h1.put(ch,h1.getOrDefault(ch,0)+1);
        }
        int matchCount=0;
        int desiredCount=t.length();
        while(true){

            boolean f1=false,f2=false;

            //acquire



            while(r<s.length()-1 && matchCount < desiredCount){
                r++;
                char ch=s.charAt(r);
                h2.put(ch,h2.getOrDefault(ch,0)+1);
                //if(h1.containsKey(ch) && (!h2.containsKey(ch) || h2.get(ch)<=h1.get(ch)) ){
                if(h2.getOrDefault(ch,0)<=h1.getOrDefault(ch,0)){
                    matchCount++;
                }
                //if(matchCount==desiredCount) break;
                f1=true;
            //calculate and release
            }while(l<r && matchCount==desiredCount){
                
                String curr=s.substring(l+1,r+1);
                if(ans.length()==0 || ans.length()>curr.length()){
                    ans=curr;
                }
                l++;
                char ch=s.charAt(l);
                h2.put(ch,h2.get(ch)-1);
                if(h2.get(ch)==0){
                    h2.remove(ch);
                }
                if(h2.getOrDefault(ch,0)<h1.getOrDefault(ch,0)){
                    matchCount--;
                }
                f2=true;
            }

            if(f1==false && f2==false) break;
        }
        return ans;
    }
}