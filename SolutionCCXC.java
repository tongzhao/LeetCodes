import java.util.HashMap;
import java.util.Map;

/**
 * Word Pattern I:
 *
 * Given a pattern and a string str, find if str follows the same pattern.

 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

 Examples:
 pattern = "abba", str = "dog cat cat dog" should return true.
 pattern = "abba", str = "dog cat cat fish" should return false.
 pattern = "aaaa", str = "dog cat cat dog" should return false.
 pattern = "abba", str = "dog dog dog dog" should return false.
 Notes:
 You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */
public class SolutionCCXC {
    public boolean wordPattern(String pattern, String str) {
        if (pattern==null && str==null) return true;
        if (pattern==null || str==null) return false;
        int length = pattern.length();
        String[] strs = str.split(" ");
        if (strs.length!=length) return false;
        Map<Character, String> map = new HashMap<Character, String>();
        for (int i = 0; i < length; i++) {
            char c = pattern.charAt(i);
            String s = strs[i];
            if (map.containsKey(c)) {
                String stored = map.get(c);
                if (!stored.equals(s)) return false;
            }
            else {
                if (map.values().contains(s)) return false;
                else map.put(c, s);
            }
        }
    return true;
    }
}
