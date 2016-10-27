/**
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it.
 * Find and return the shortest palindrome you can find by performing this transformation.

 For example:

 Given "aacecaaa", return "aaacecaaa".

 Given "abcd", return "dcbabcd".

 Given "aebcdba", return "aedcbcdea".

 Given "abecdbea", return "aebdcabebacdbea".
 */
public class SolutionCCXIV {
    public String shortestPalindrome(String s) {
        int j = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(j)) j++;
        }
        if (j==s.length()) return s; // s itself is a palindrome
        String suffix = s.substring(j);
        return new StringBuffer(suffix).reverse().toString() +
               shortestPalindrome(s.substring(0, j)) + suffix;
    }
}
