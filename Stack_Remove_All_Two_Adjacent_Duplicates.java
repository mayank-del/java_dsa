class Solution {
    public String removeDuplicates(String s) {


        //87/106 test case passed soln
       /* String res= f(s);

        //if(res=="") return res+=s.charAt(0);
        return res;

    }
    String f(String s){
        StringBuilder sb=new StringBuilder();
        int n=s.length();
        for(int i=0;i<n-1;){
            if(s.charAt(i)==s.charAt(i+1)){
                i++;
                i++;
            }else{
                
                sb.append(s.charAt(i));
                i++;
            }
        }
        if(s.length()%2!=0 && sb.length()==0) sb.append(s.charAt(n-1));
        if(s.length()>=2 && s.charAt(n-1)!=s.charAt(n-2)) sb.append(s.charAt(n-1));
        String s1=sb.toString();

        if(s.length()==s1.length()) return s;
        else return f(s1); */


        Stack<Character> st=new Stack<>();
        int n=s.length();
        //st.push(s.charAt(0));
        for(int i=0;i<n;i++){
            if(st.isEmpty()||st.peek()!=s.charAt(i))
                st.push(s.charAt(i));
            else if(!st.isEmpty() && st.peek()==s.charAt(i))
                st.pop();
        }

        StringBuilder sb=new StringBuilder();

        for(;st.size()!=0;){
            sb.append(st.pop());
        }
        String res=sb.reverse().toString();
        return res;
        
    }
}