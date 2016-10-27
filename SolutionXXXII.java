import java.util.Stack;

public class SolutionXXXII {
    public static int longestValidParentheses(String s) {
        if (s==null || s.length()<2) return 0;
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int last = -1;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c=='(') {
                stack.push(i);
            }
            else {
                if (stack.isEmpty()) {
                    last = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        max = Math.max(i-last, max);
                    } else {
                        max = Math.max(i-stack.peek(), max);
                    }
                }
            }
            i++;
        }
        return max;
    }
    public static void main(String[] args) {
        //String s = "()()";
        String s = ")(";
        System.out.println("s: " + longestValidParentheses(s));
    }
}
