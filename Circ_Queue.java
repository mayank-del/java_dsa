public class Circ_Queue {
    protected int[] data;
    private static final int Size=5;

    protected int end=0;
    protected int front=0;
    private int size=0;
    public Circ_Queue(){
        this(Size);
    }
    public Circ_Queue(int size){
        this.data=new int[Size];
    }
    public boolean isFull(){
        return size==data.length;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public boolean Insert(int item){
        if(isFull()){
            return false;
        }
        else{
            data[end++]=item;
            end=end % data.length;
            size++;
            return true;
        }
    }
    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }
        else{
            int removed=data[front++];
            System.out.println(data[front]+"removed");
            size--;
             return removed;

        }
    }
    public int front() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty");
        
        }
        return data[front];
    }
    public void display(){
        if(isEmpty()){
            System.out.println("queue is empty");
            return;
        }
        int i=front;
        do{
            System.out.print(data[i]+"->");
            i++;
            i%=data.length;
        }while(i!=end);
        

    }
    public static void main(String[] args) {
        Circ_Queue q=new Circ_Queue(5);

        q.Insert(8);
        q.Insert(12);
        q.Insert(5);
        q.Insert(9);
        q.Insert(98);


        q.display();
    }
}
