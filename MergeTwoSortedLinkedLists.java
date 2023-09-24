//{ Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}


class MergeLists
{
    Node head;



  /* Function to print linked list */
   public static void printList(Node head)
    {
        
        while (head!= null)
        {
           System.out.print(head.data+" ");
           head = head.next;
        }  
        System.out.println();
    }
	
	 
 
     /* Driver program to test above functions */
    public static void main(String args[])
    {
       
         
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 
		 while(t>0)
         {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			Node head1 = new Node(sc.nextInt());
            Node tail1 = head1;
            for(int i=0; i<n1-1; i++)
            {
                tail1.next = new Node(sc.nextInt());
                tail1 = tail1.next;
            }
			Node head2 = new Node(sc.nextInt());
            Node tail2 = head2;
            for(int i=0; i<n2-1; i++)
            {
                tail2.next = new Node(sc.nextInt());
                tail2 = tail2.next;
            }
			
			LinkedList obj = new LinkedList();
			Node head = obj.sortedMerge(head1,head2);
			printList(head);
			
			t--;
			
         }
    }
}

// } Driver Code Ends


/*
  Merge two linked lists 
  head pointer input could be NULL as well for empty list
  Node is defined as 
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class LinkedList
{
    //Function to merge two sorted linked list.
    Node sortedMerge(Node head1, Node head2) {
     // This is a "method-only" submission. 
     // You only need to complete this method
     
     int idx1=0;
     int idx2=0;
     Node temp=head1;
     Node temp2=head2;
     Node res =null;
     Node temp3=res;
     while(temp!=null && temp2!=null){
        if(temp.data<=temp2.data){
            if(res==null){
                res=new Node(temp.data);
                temp=temp.next;
                temp3=res;
                continue;
            }
           
            Node newNode= new Node(temp.data);
            temp3.next=newNode;
            temp3=temp3.next;
            temp=temp.next;
        }else{
            if(res==null){
                res=new Node(temp2.data);
                temp3=res;
                temp2=temp2.next;
                continue;
            }
            Node newNode= new Node(temp2.data);
        
            temp3.next=newNode;
            temp3=temp3.next;
            temp2=temp2.next;
        }
        
        
     }
     
     while(temp!=null){
            Node newNode= new Node(temp.data);
        
            temp3.next=newNode;
            temp3=temp3.next;
            temp=temp.next;
        }
        
        while(temp2!=null){
            Node newNode= new Node(temp2.data);
            temp3.next=newNode;
            temp3=temp3.next;
            temp2=temp2.next;
        }
        
   /* temp3=res;

   while(temp3!=null && temp3.next!=null){
      if(temp3.data==temp3.next.data){
          temp3.next=temp3.next.next;
      }
      temp3=temp3.next;
   }  */  
    
     return res;
   }
   
   
}
