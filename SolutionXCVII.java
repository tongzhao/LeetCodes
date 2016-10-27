/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 For example,
 Given:
 s1 = "aabcc",
 s2 = "dbbca",
 When s3 = "aadbbcbcac", return true.
 When s3 = "aadbbbaccc", return false.
 */
public class SolutionXCVII {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1+len2!=len3) return false;
        boolean[][] res = new boolean[len1+1][len2+1];
        res[0][0] = true;
        for (int i = 1; i <= len2; i++) {
            res[0][i] = res[0][i-1] && s2.charAt(i-1)==s3.charAt(i-1);
        }
        for (int i = 1; i <= len1; i++) {
            res[i][0] = res[i-1][0] && s1.charAt(i-1)==s3.charAt(i-1);
        }
        for (int i = 1; i <= len1; i++) {
            char c1 = s1.charAt(i-1);
            for (int j = 1; j <= len2; j++) {
                char c2 = s2.charAt(j-1);
                char c3 = s3.charAt(i+j-1);
                if (c1==c3) res[i][j] = res[i-1][j];
                if (c2==c3) res[i][j] = res[i][j] || res[i][j-1];
            }
        }
        return res[len1][len2];
    }
}
