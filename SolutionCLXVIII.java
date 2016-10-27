/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

 For example:

 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB
 */
public class SolutionCLXVIII {
    public String convertToTitle(int n) {
        String res = "";
        while(n > 0) {
            n--;
            int remain = n % 26;
            char add = (char)('A'+remain);
            res = add + res;
            n = n/26;
        }
        return res;
    }
}
