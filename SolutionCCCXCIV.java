import java.util.Stack;

/**
 * 394. Decode String
 *
 * Examples:

 s = "3[a]2[bc]", return "aaabcbc".
 s = "3[a2[c]]", return "accaccacc".
 s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class SolutionCCCXCIV {
    public String decodeString(String s) {
        String res = "";
        if (s==null || s.length()==0) return res;
        int index = 0;
        Stack<Integer> countStack = new Stack<Integer>();
        Stack<String> resStack = new Stack<String>();
        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int count = 0;
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    count = 10 * count + (s.charAt(index)-'0');
                    index++;
                }
                countStack.push(count);
            } else if (s.charAt(index) == '[') {
                resStack.push(res);
                res = "";
                index++;
            } else if (s.charAt(index) == ']') {
                StringBuilder sb = new StringBuilder(resStack.pop());
                int repeatCount = countStack.pop();
                for (int i = 0; i < repeatCount; i++) {
                    sb.append(res);
                }
                res = sb.toString();
                index++;
            } else res += s.charAt(index++);
        }
        return res;
    }
}
