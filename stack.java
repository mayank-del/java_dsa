import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public interface stack {
    public static void main(String args[]){
/*      Stack<Integer> stack=new Stack<>();
        stack.push(45);
        stack.push(1);
        stack.push(59);
        stack.push(45466);

        System.out.print(stack.pop()); */

/*      Queue<Integer> queue=new LinkedList<>();
        queue.add(56);
        queue.add(45);
        System.out.println(queue.remove()); */

        Deque<Integer> deque =new ArrayDeque<>();
        deque.add(787);
        deque.addLast(86);
        deque.removeFirst();


}
}
