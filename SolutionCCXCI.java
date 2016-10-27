import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Word Pattern II:
 *
 * Given a pattern and a string str, find if str follows the same pattern.

 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.

 Examples:
 pattern = "abab", str = "redblueredblue" should return true.
 pattern = "aaaa", str = "asdasdasdasd" should return true.
 pattern = "aabb", str = "xyzabcxzyabc" should return false.
 Notes:
 You may assume both pattern and str contains only lowercase letters.
 */
public class SolutionCCXCI {
    Map<Character,String> map =new HashMap();
    Set<String> set =new HashSet();
    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern.isEmpty()) return str.isEmpty();
        if (map.containsKey(pattern.charAt(0))) {
            String value = map.get(pattern.charAt(0));
            if (str.length() < value.length() || !str.substring(0, value.length()).equals(value)) return false;
            if (wordPatternMatch(pattern.substring(1), str.substring(value.length()))) return true; // rest recursive function
        } else {
            for (int i = 1; i <= str.length(); i++) {
                if (set.contains(str.substring(0, i))) continue;
                // update map and set once valid
                map.put(pattern.charAt(0), str.substring(0, i));
                set.add(str.substring(0, i));
                if (wordPatternMatch(pattern.substring(1), str.substring(i))) return true;
                set.remove(str.substring(0, i));
                map.remove(pattern.charAt(0));
            }
        }
        return false;
    }
}
