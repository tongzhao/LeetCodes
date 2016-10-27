import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.

 The expression string may contain open ( and closing parentheses ),
 the plus + or minus sign -, non-negative integers and empty spaces .
 */
public class SolutionCCXXIV {
    public int calculate(String s) {
        /**
         * 5 - ( 6 + ( 4 - 7 ) ), if we remove all parentheses,
         * the expression becomes 5 - 6 - 4 + 7.
         sign:
         6: (-1)(1) = -1
         4: (-1)(1)(1) = -1
         7: (-1)(1)(-1) = 1
         */
        Stack<Integer> stack = new Stack<Integer>();
        int rs = 0;
        int sign = 1;
        stack.push(1);
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ' ') continue;
            else if (s.charAt(i) == '('){
                stack.push(stack.peek() * sign);
                sign = 1;
            }
            else if (s.charAt(i) == ')') stack.pop();
            else if (s.charAt(i) == '+') sign = 1;
            else if (s.charAt(i) == '-') sign = -1;
            else{
                int temp = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1)))
                    temp = temp * 10 + s.charAt(++i) - '0';
                rs += sign * stack.peek() * temp;
            }
        }
        return rs;
    }
}
