class Solution {
    public String makeGood(String s) {
        Stack<Character> st=new Stack<>();

        for(Character ch:s.toCharArray()){
            if(!st.isEmpty()){
                char peekEle=st.peek();
                if((peekEle-'a'>=0 && ch-'a'<0 && peekEle-'a'==ch-'A')|| (peekEle-'a'<0 && ch-'a'>=0 && peekEle-'A'==ch-'a')){
                    st.pop();
                    continue;
                }
            }
            st.push(ch);
            
        }
        StringBuilder res=new StringBuilder();
        for(;!st.isEmpty();){
            res.append(st.pop());
        }
        res.reverse();
        return res.toString();
    }
}