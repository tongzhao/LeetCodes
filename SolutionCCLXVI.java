import java.util.HashMap;
import java.util.Map;

/**
 * Palindrome Permutation:
 Given a string, determine if a permutation of the string could form a palindrome.
 For example,
 "code" -> False, "aab" -> True, "carerac" -> True.
 */
public class SolutionCCLXVI {
    public boolean canPermutePalindrome(String s) {
        if (s==null || s.length()<=1) return true;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) map.put(c, map.get(c)+1);
            else map.put(c, 1);
        }
        int count = 0;
        for (int i: map.values()) {
            if (i % 2==1) count++;
        }
        return count <= 1;
    }
}
