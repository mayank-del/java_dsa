//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
        
        //reversing first linkedlist
        
        Node curr=first;
        Node prev=null;
        while(curr!=null){
            Node n=curr.next;
            curr.next=prev;
            prev=curr;
            curr=n;
        }
        
        first=prev;
        
        //reversing second linkedlist
        
        curr=second;
        prev=null;
        while(curr!=null){
            Node n=curr.next;
            curr.next=prev;
            prev=curr;
            curr=n;
        }
        
        second=prev;
        
        //return first;
        
    int carry=0;
        int num=0;
        Node head=new Node(0);
        Node temp=head;
        while(first!=null && second!=null){
            
            num=(first.data+second.data);
            
            int sum=(carry+num)%10;
            Node n=new Node(sum);
            temp.next=n;
            carry =(num+carry)/10;
            
            first=first.next;
            second=second.next;
            temp=temp.next;
        
        }
        
        while(first!=null){
            num=(first.data);
            
            int sum=(carry+num)%10;
            Node n=new Node(sum);
            temp.next=n;
            
            carry =(num+carry)/10;
            first=first.next;

            temp=temp.next;
        }
        
        while(second!=null){
            num=(second.data);
            
            int sum=(carry+num)%10;
            Node n=new Node(sum);
            temp.next=n;
            
            carry =(carry+num)/10;
            second=second.next;

            temp=temp.next;
        }
        if(carry!=0){
            Node n=new Node(carry);
            temp.next=n;
            
            temp=temp.next;
        }
        
        curr=head.next;
        head.next=null;
        
        prev=null;
        while(curr!=null){
            Node n=curr.next;
            curr.next=prev;
            prev=curr;
            curr=n;
        }
        
        head=prev;
        
        return head;
        
        
    }
}