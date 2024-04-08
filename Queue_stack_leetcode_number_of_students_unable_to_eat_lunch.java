class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> st=new Stack<>();
        Queue<Integer> q=new LinkedList<>();

        for(int it:students){
            q.add(it);
        }

        for(int i=sandwiches.length-1;i>=0;i--){
            st.push(sandwiches[i]);
        }
        int size=sandwiches.length,n=0;
        while(!st.isEmpty() && !q.isEmpty()){
            size=q.size();
            if(n==size){
                return n;
            }else if(st.peek()!=q.peek()){
                int top=q.remove();
                q.add(top);
                n++;
            }else if(st.peek()==q.peek()){
                n=0;
                q.remove();
                st.pop();

            }
        }

        return n;
    }
}