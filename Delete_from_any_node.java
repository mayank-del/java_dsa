public class Delete_from_any_node {
    class Node {
        int num;
        Node next;
        Node(int a) {
            num = a;
            next = null;
        }
}
static Node getNode(Node head,int val) {
    if(head==null)
    return null;
    while(head.num != val) head = head.next;
    
    return head;
}
    static void deleteNode(Node t) {
        if(t==null)
        return;
        t.num = t.next.num;//node ke value ke jagah node ke agage wale node ka value
        t.next = t.next.next;//node ke next me next to next waale ka address
        return;
    } 
}
