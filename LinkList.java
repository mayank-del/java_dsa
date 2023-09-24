/* import java.util.LinkedList;

public class LinkList {
    public static void main(String[] args) {
        LinkedList<Integer> list=new LinkedList<>();
        list.add(34);
        list.addFirst(45);
        System.out.println(list);
    }
} */
public class LinkList{
        Node head;
        private int size;

        LinkList(){
            this.size=0;
        }

        class Node{
            String data;
            Node next;
        
            Node(String data){
                this.data=data;
                this.next=null;
                size++;
            }

       }
               //add first
        public void addFirst(String data){
            Node newNode=new Node(data);
            if(head==null){
                head=newNode;
                return;
                }
            newNode.next=head;
            head=newNode;
            }
            //add Last
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
                //delete first
                public void deleteFirst(){
                    if(head==null){
                        System.out.println("Linkedlist is empty");
                        return;
                    }
                    head=head.next;
                    size--;
                }
                //delete last
                public void deleteLast(){
                    if(head==null){
                        System.out.println("Linkedlist is empty");
                        return;
                    }
                    Node currNode=head;
                    while(currNode.next.next!=null){
                        currNode=currNode.next;

                    }
                    currNode.next=null;
                    size--;
                }

            public void printList(){
                if(head==null){
                    System.out.println("Linkedlist is Empty");
                }
                Node currNode=head;
                while(currNode !=null){
                    System.out.print(currNode.data+"->");
                    currNode=currNode.next;   
                            }
                    System.out.print("Null");
            }
  /*           public void reverse(){
                if(head==null){
                    System.out.println("Linkedlist is Empty");
                }
                Node currNode=head;
                Node revNode=head;
                revNode.next=null;
                
                while(currNode!=null){
                    head=revNode;
                    revNode.data=currNode.data;
                    currNode=currNode.next;
                    revNode.next=head;
                }
                while(revNode!=null){
                    System.out.print(revNode.data+"->");
                    revNode=revNode.next;   
                            }
                    System.out.print("Null");
              
            } */
            public void reverse(){
                if(head==null || head.next==null){
                    return;
                }
                Node prevNode=head;
                Node currNode=head.next;
                while(currNode!=null){
                    Node nextNode=currNode.next;

                    //update
                    currNode.next=prevNode;
                    prevNode=currNode;
                    currNode=nextNode;
                }
                head.next=null;
                head=prevNode;
              
            
            }
            public void middleElement(){
                if(head==null || head.next==null){
                    return;
                }
                Node currNode=head;
                int middle=size/2;
                while(middle!=0){
                    currNode=currNode.next;
                    middle--;
                }
                System.out.println(currNode.data);
            }
            public int getSize(){
                return size;
            }
            public void removeNthNodeFromBack(int index){
                int traverseIndex=(size-1) - index;
                Node Curr=head;
                while(traverseIndex!=0){
                    Curr=Curr.next;
                    traverseIndex--;

                }
                System.out.println(Curr.data);
            }

    public static void main(String[] args) {
        LinkList list=new LinkList();
        list.addFirst("is");
        list.addFirst("mIke");
        list.addLast("Hero");

        //list.deleteFirst();
        //list.printList();
        //list.getSize();
      
        //list.middleElement();
        list.removeNthNodeFromBack(1);

       // System.out.println(list.getSize());

    }
}

