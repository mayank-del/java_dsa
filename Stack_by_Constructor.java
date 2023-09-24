public class Stack_by_Constructor{
    protected int[] data;
    private static final int Default_size=10;

    int ptr=-1;

    public Stack_by_Constructor(){
        this(Default_size);
    }
    public Stack_by_Constructor(int size){
        this.data=new int[size];
    }
    public boolean push(int item){
        if(isFull()){
            System.out.println("Srtack is full");
        }
        ptr++;
        data[ptr]=item;
        return true;
    }
    public int pop() throws Exception{
        if(isEmpty()){
            throw new Exception("cannot pop from an empty stack.");
        }
        int removed =data[ptr];
        ptr--;
        return removed;
        //return data[ptr--];
    }
    private boolean isFull(){
        return ptr== data.length-1;
    }
    private boolean isEmpty(){
        return ptr==-1;
    }
    public int peek() throws Exception{
        if(isEmpty()){
            throw new Exception("cannot find peek from an empty stack.");
        }
        return data[ptr];
    }
}
