import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

 Valid operators are +, -, *, /.
 Each operand may be an integer or another expression.

 Some examples:
 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class SolutionCL {
    public int evalRPN(String[] tokens){
        if(tokens.length==0) return 0;
        Stack<Integer> s = new Stack<Integer>();
        int op1 = 0;
        int op2 = 0;
        int val = 0;
        for(String token:tokens){
            if(!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")){
                val = Integer.parseInt(token);
            }
            else{
                op2 = s.pop();
                op1 = s.pop();
                val = operation(op1, op2, token);
            }
            s.push(val);
        }
        return val;
    }
    public int operation(int op1, int op2, String token){
        int res = -1;
        if (token.equals("+")) {
            res = op1 + op2;
        } else if (token.equals("-")) {
            res = op1 - op2;
        } else if (token.equals("*")) {
            res = op1 * op2;
        } else if (token.equals("/")) {
            if (op2 == 0) return -1;
            res = op1 / op2;
        }
        return res;
    }
}
