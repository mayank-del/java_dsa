class MyStack {
    Queue<Integer> q;
    Queue<Integer> q2;

    public MyStack() {
        q =new LinkedList<>();
        q2=new LinkedList<>();
    }
    
    public void push(int x) {
        q.add(x);
    }
    
    public int pop() {
        while(q.size()>1){
            q2.add(q.poll());
        }
        int ele=-1;
        if(!q.isEmpty())
            ele=q.remove();
        
        while(!q2.isEmpty()){
            q.add(q2.remove());
        }
        return ele;
        
    }
    
    public int top() {
        while(q.size()>1){
            q2.add(q.remove());
        }
        int ele=q.peek();
        if(!q.isEmpty())
            q2.add(q.remove());
    
        while(!q2.isEmpty()){
            q.add(q2.remove());
        }
        return ele;
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */