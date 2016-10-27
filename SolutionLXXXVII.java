import java.util.Arrays;

/**
 * We say that "rgtae" is a scrambled string of "great".
 Given two strings s1 and s2 of the same length,
 determine if s2 is a scrambled string of s1
 */
public class SolutionLXXXVII {
    public boolean isScramble(String s1, String s2) {
        // special cases
        if(s1.length()!=s2.length()) return false;
        if(s1.equals(s2)) return true;
        // consider sort arrays
        String str1 = s1;
        String str2 = s2;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        s1 = new String(c1);
        s2 = new String(c2);
        if(!s1.equals(s2)) return false;
        for(int i=1; i<s1.length(); i++){
            if ((isScramble(str1.substring(0, i), str2.substring(0, i))
                 &&isScramble(str1.substring(i), str2.substring(i))) ||
                (isScramble(str1.substring(0, i), str2.substring(s2.length()-i))
                 &&isScramble(str1.substring(i), str2.substring(0, s2.length()-i)))) // to check if there is one possibility
                return true;
        }
        return false;
    }
}
