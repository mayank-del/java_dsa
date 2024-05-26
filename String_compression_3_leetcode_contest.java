class Solution {
    public String compressedString(String word) {
        int n=word.length();
        int cnt=1;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n-1;i++){
            if(word.charAt(i)==word.charAt(i+1)){
                cnt++;
                if(cnt==9){
                    sb.append(cnt);                
                    sb.append(""+word.charAt(i)); 
                    cnt=0;
                }
            }else {
                sb.append(cnt);                
                sb.append(""+word.charAt(i));
                cnt=1;

            }
            
        }
        
        sb.append(cnt);                
        sb.append(""+word.charAt(n-1));
        String res=sb.toString();
        for(int i=0;i<res.length()-1;i++){
            if(res.charAt(i)=='0'){
                res=res.substring(0,i)+res.substring(i+2);
            }
        }
        return res;
    }
}