/**
 * 344. Reverse String
 *
 * Write a function that takes a string as input and returns the string reversed.

 Example:
 Given s = "hello", return "olleh".
 */
public class SolutionCCCXLIV {
    public String reverseString(String s) {
        if (s==null || s.length()==0) return "";
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length/2; i++) {
            char c = ch[i];
            ch[i] = ch[ch.length-1-i];
            ch[ch.length-1-i] = c;
        }
        return new String(ch);
    }
}
