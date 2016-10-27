/**
 * Related to question Excel Sheet Column Title
 Given a column title as appear in an Excel sheet, return its corresponding column number.
 For example:

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28
 */
public class SolutionCLXXI {
    public static int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int val = c - 'A';
            res = 26 * res + (val+1);
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "ZA";
        System.out.print("Res: "+titleToNumber(s));
    }
}
