//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Rearr
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                temp.next = new Node(a);
                temp = temp.next;
            }
            
            Solution ob = new Solution();
            ob.rearrange(head);
            printLast(head);
            System.out.println();
        }
    }
    
    public static void printLast(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
class Solution
{
    public static void rearrange(Node head)
    {
        // add your code here
        Node temp=head;
        Node temp3=null;
        Node temp2=head;
        int cnt=0;
        Stack<Integer> arr=new Stack<>();
        
        while(temp2!=null ){
            if(cnt%2!=0){
                arr.push(temp2.data);
            }
            temp2=temp2.next;
            cnt++;
        }
        
        while(temp!=null && temp.next!=null){
            temp.next=temp.next.next;
            temp3=temp;
            temp=temp.next;
                
            
        }
        if(cnt%2!=0){
            temp3=temp;
        }
        while(!arr.isEmpty()){
            if(temp3!=null){
                temp3.next=new Node(arr.pop());
                temp3=temp3.next; 
            }
            
        }
        /*while(temp!=null && temp.next!=null){
            
                temp.next=temp.next.next;
                temp=temp.next;
            
        }*/
        
            
        //return head;
    }
}
