import java.util.Stack;

/**
 * 151. Reverse Words in a String
 *
 * Given an input string, reverse the string word by word.
 For example,
 Given s = "the sky is blue",
 return "blue is sky the".
 */
public class SolutionCLI {
    public static String reverseWords(String s){
        String[] str = s.split(" ");
        Stack<String> stack = new Stack<String>();
        StringBuilder sb = new StringBuilder();
        for(String iter : str){
            if(!iter.equals("")) stack.push(iter);
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
            if(!stack.isEmpty()) sb.append(" ");
        }
        return sb.toString();
    }
}
