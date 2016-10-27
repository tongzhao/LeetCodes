/**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 A subsequence of a string is a new string which is formed from the original string
 by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters.
 (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

 Here is an example:
 S = "rabbbit", T = "rabbit"
 Return 3.
 */
public class SolutionCXV {
    public int numDistinct(String s, String t) {
        /**
         * @ r a b b b i t
         * r 1 1 1 1 1 1 1
         * a   1 1 1 1 1 1
         * b     1 2 3 3 3
         * b       1 3 3 3
         * i           3 3
         * t             3
         */
        if (s.length() < t.length()) return 0;
        int[][] res = new int[t.length()][s.length()];
        // initialize the 1st row
        for (int j = 0; j < s.length(); j++) {
            char ct = t.charAt(0);
            char cs = s.charAt(j);
            if (j==0) res[0][j] = ct==cs ? 1: 0;
            else res[0][j] = ct==cs ? res[0][j-1]+1 : res[0][j-1];
        }
        // other lines
        for (int i = 1; i < t.length(); i++) {
            char ct = t.charAt(i);
            for (int j = i; j < s.length(); j++) {
                char cs = s.charAt(j);
                res[i][j] = ct==cs ? res[i][j-1] + res[i-1][j-1] : res[i][j-1];
            }
        }
        return res[t.length()-1][s.length()-1];
    }
}
