import java.util.Stack;

/**
 * Design a stack that supports push, pop, top,
 * and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.
 */
public class SolutionCLV {
    public Stack<Integer> nums = new Stack<Integer>();
    public Stack<Integer> min = new Stack<Integer>();
    public void push(int x) {
        // when input is smallest...
        nums.push(x);
        if (min.isEmpty() || x <= min.peek()) min.push(x);
    }
    public void pop() {
        if (nums.isEmpty()) return;
        if (nums.peek().equals(min.peek())) min.pop();
        nums.pop();
    }
    public int top() {
        return nums.peek();
    }
    public int getMin() {
        return min.peek();
    }
}
