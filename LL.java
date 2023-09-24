public class LL {
    Node head;
    private int size;
    LL(){
        this.size=0;
    }
    public class Node{
        String data;
        Node next;

        Node(String data){
            this.data=data;
            this.next=null;
            size++;
        }
    }
    public void addFirst(String data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }
    public void addLast(String data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node currNode=head;
        while(currNode.next!=null){
            currNode=currNode.next;
        }
        currNode.next=newNode;
        newNode.next=null;
        
    }
    public void deleteFirst(){
        if(head==null){
            System.out.println("Linkedlist is empty");
            return;
        }
        head=head.next;
    }
    public void deleteLast(){
        if(head==null){
            System.out.println("Linkedlist is empty");
        }
        Node currNode=head;
        while(currNode.next!=null){
            currNode=currNode.next;
        }
        currNode.next=null;
        size--;
    }
    public void reverse(){
        if(head==null || head.next==null){
            return;
        }
        Node prevNode=head;

        Node CurrNode=head.next;
        while(CurrNode!=null){
            Node nextNode=CurrNode.next;

            //update
            CurrNode.next=prevNode;
            prevNode=CurrNode;
            CurrNode=nextNode;
        }
        head.next=null;
        head=prevNode;
    }
    
}
