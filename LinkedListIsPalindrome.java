//{ Driver Code Starts
import java.util.*;

class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}

class Is_LinkedList_Palindrom
{
	 Node head;  
	 Node tail;
	
	/* Function to print linked list */
    void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	
 
    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) 
	{

		if (head == null) 
		{
			head = node;
			tail = node;
		} else 
		{
		    tail.next = node;
		    tail = node;
		}
    }
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		 
		while(t>0)
        {
			int n = sc.nextInt();
			//int k = sc.nextInt();
			Is_LinkedList_Palindrom llist = new Is_LinkedList_Palindrom();
			//int n=Integer.parseInt(br.readLine());
			int a1=sc.nextInt();
			Node head= new Node(a1);
            Node tail = head;
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
			    tail.next = new Node(a);
			    tail = tail.next;
			}
			
			Solution g = new Solution();
			if(g.isPalindrome(head) == true)
			    System.out.println(1);
		    else
			    System.out.println(0);
			t--;
		}
		
	}
}




// } Driver Code Ends


/* Structure of class Node is
class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}*/

class Solution
{
    //Function to check whether the list is palindrome.
    
    boolean isPalindrome(Node head) 
    {
        //Your code here
        
        Stack<Integer> st=new Stack<>();
        Queue<Integer> q=new LinkedList<>();
        
        int count =0;
        Node temp=head;
        while(temp!=null ){
            temp=temp.next;
            count++;
            
        }
        int half=count/2;
        int nextHalf=half;
        
        Node temp2=head;
        
        int totCount=count;
        count=0;
        while(temp2!=null){
            if(count<half){
                st.add(temp2.data);
            }else{
                q.add(temp2.data);
            }
            temp2=temp2.next;
            count++;
        }
        
        if(totCount%2!=0){
            q.remove();
        }
        if(st.size()!=q.size()){
            return false;
        }
        
        while(!st.isEmpty() && !q.isEmpty()){
            if(st.pop()!=q.remove()){
                return false;
            }
        }
        return true;
    }    
}

