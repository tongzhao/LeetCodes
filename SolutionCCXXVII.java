import java.util.Stack;

/**
 * Basic Calculator II
 */
public class SolutionCCXXVII {
    public int calculate(String s) {
        if (s==null || s.length()==0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) num = 10 * num + c - '0';
            if (!Character.isDigit(c) &&' '!=c || i==s.length()-1) {
                if (sign=='-') stack.push(-num);
                if (sign=='+') stack.push(num);
                if (sign=='*') stack.push(stack.pop() * num);
                if (sign=='/') stack.push(stack.pop() / num);
                sign = c;
                num = 0;
            }
        }
        int res = 0;
        for (int i: stack) res += i;
        return res;
    }
}
