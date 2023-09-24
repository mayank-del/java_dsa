class Pair{
    char ch;
    int freq;
    Pair(char ch,int freq){
        this.ch=ch;
        this.freq=freq;
    }
}

class Solution {
    public String removeDuplicates(String s, int k) {

        Stack<Pair> st=new Stack<>();
        int n=s.length();

        for(int i=0;i<n;i++){
            if(st.isEmpty()){
                st.push(new Pair(s.charAt(i),1));
            }else if(!st.isEmpty() && st.peek().ch==s.charAt(i) && st.peek().freq!=k-1){
                st.push(new Pair(s.charAt(i),st.peek().freq+1));
            }else if(!st.isEmpty() && st.peek().ch!=s.charAt(i)){
                st.push(new Pair(s.charAt(i),1));
            }else if(!st.isEmpty() && st.peek().ch==s.charAt(i) && st.peek().freq==k-1){
                int x=k-1;
                while(x>0){
                    st.pop();
                    x--;
                }
            }
        }
        StringBuilder sb=new StringBuilder();

        for(;st.size()!=0;){
            sb.append(st.pop().ch);
        }
        String res=sb.reverse().toString();
        return res;
    }
}