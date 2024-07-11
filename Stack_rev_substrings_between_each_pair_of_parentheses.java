import java.util.*;
public class Stack_rev_subs {
    public static void main(String[] args) {
            String s="(a(bcdefghijkl(mno)p)q)";
            Stack<String> st=new Stack<>();
            String temp="";
            int cnt=0;
            for(char ch:s.toCharArray()){
                if(ch=='('){
                    if(!temp.equals("")){
                        st.push(temp);
                        temp="";
                    }
                }else if(ch==')'){
                    if(cnt==s.length()-1){
                        String res=temp;
                        while(!st.isEmpty()){
                            res=st.pop()+res;
                        }
                        char arr[]=res.toCharArray();
                        int n=res.length();
                        for(int i=0;i<n/2;i++){
                            char t=arr[i];
                            arr[i]=arr[n-i-1];
                            arr[n-i-1]=t;
    
                        }
                        res=new String(arr);
                        System.out.println("line 29:"+res);
                    }if(!temp.equals("")){
                        st.push(temp);
                        temp="";
                    }
                    String top=st.pop();
                    char arr[]=top.toCharArray();
                    int n=top.length();
                    for(int i=0;i<n/2;i++){
                        char t=arr[i];
                        arr[i]=arr[n-i-1];
                        arr[n-i-1]=t;
    
                    }
                    top=new String(arr);
                    if(!st.isEmpty()){
                        String pre=st.pop();
                        top=pre+top;
                    }
                    st.push(top);
                    System.out.println("line 49:"+top);
                }else{
                    temp+=ch;
                }
                cnt++;
            }
        
        
    }
}
