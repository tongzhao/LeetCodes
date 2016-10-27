import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.

 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.
 */
public class SolutionCCXLII {
    public boolean isAnagram(String s, String t) {
        if (s==null || t==null) return false;
        if (s.length()!=t.length()) return false;
        Map<Character, Integer> smap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (!smap.containsKey(s.charAt(i))) smap.put(s.charAt(i), 1);
            else smap.put(s.charAt(i), smap.get(s.charAt(i))+1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!smap.containsKey(c) || smap.get(c)==0) return false;
            smap.put(c, smap.get(c)-1);
        }
        return true;
    }
}
