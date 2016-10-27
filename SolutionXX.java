import java.util.Stack;

public class SolutionXX {
    public boolean isValid(String s) {
        if (s==null || s.length()==0) return false;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c=='(' || c=='[' || c=='{') {
                stack.push(c);
            }
            else if (stack.isEmpty() && (c==')' || c==']' || c=='}')) return false;
            else if (stack.peek()=='(' && c!=')') return false;
            else if (stack.peek()=='[' && c!=']') return false;
            else if (stack.peek()=='{' && c!='}') return false;
            else stack.pop();
        }
        return stack.isEmpty();
    }
}
