import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement the following operations of a stack using queues.
 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 empty() -- Return whether the stack is empty.
 */
public class SolutionCCXXV {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    public void push(int x) {
        if (empty()) q1.add(x);
        else {
            if (q1.size() > 0) {
                q2.add(x);
                int size = q1.size();
                while (size > 0) {
                    q2.add(q1.poll());
                    size--;
                }
            } else if (q2.size() > 0) {
                q1.add(x);
                int size = q2.size();
                while (size > 0) {
                    q1.add(q2.poll());
                    size--;
                }
            }
        }
    }

    public int pop() {
        if (q1.size() > 0) return q1.poll();
        return q2.poll();
    }

    public int top() {
        if (q1.size() > 0) return q1.peek();
        else if (q2.size() > 0) return q2.peek();
        return 0;
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
