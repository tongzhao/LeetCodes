/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

 You have the following 3 operations permitted on a word:

 a) Insert a character
 b) Delete a character
 c) Replace a character
 */
public class SolutionLXXI {
    public int minDistance(String word1, String word2) {
        /**
         * @   H E L L O
         * 0 0 1 2 3 4 5
         * E 1 2 1 2 3 4
         * L ...
         * L ...
         * O ...
         */
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1==0) return len2;
        if (len2==0) return len1;
        int[][] res = new int[len1+1][len2+1];
        res[0][0] = 0;
        for (int i=1; i <= len2; i++) {
            res[0][i] = i;
        }
        for (int i=1; i <= len1; i++) {
            res[i][0] = i;
        }
        for (int i=1; i<=len1; i++) {
            char c1 = word1.charAt(i-1);
            for (int j=1; j<=len2; j++) {
                char c2 = word2.charAt(j-1);
                if (c1==c2) res[i][j] = res[i-1][j-1];
                else res[i][j] = Math.min(res[i-1][j-1], Math.min(res[i-1][j], res[i][j-1])) + 1;
            }
        }
        return res[len1][len2];
    }
}
