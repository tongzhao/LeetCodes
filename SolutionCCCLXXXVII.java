import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 387. First Unique Character in a String
 *
 * Given a string, find the first non-repeating character in it and return it's index.
 * If it doesn't exist, return -1.

 Examples:

 s = "leetcode"
 return 0.

 s = "loveleetcode",
 return 2.
 Note: You may assume the string contain only lowercase letters.
 */
public class SolutionCCCLXXXVII {
    public int firstUniqChar(String s) {
        int res = -1;
        Set<Character> visited = new HashSet<Character>();
        HashMap<Character, Integer> locs = new HashMap<Character, Integer>();
        if (s==null || s.length()==0) return res;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!visited.contains(c)) {
                visited.add(c);
                locs.put(c, i);
            } else {
                locs.remove(c);
            }
        }
        if (locs.isEmpty()) return res;
        res = Integer.MAX_VALUE;
        for (int loc : locs.values()) res = loc < res ? loc : res;
        return res;
    }
}
