import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

 For example,
 S = "ADOBECODEBANC"
 T = "ABC"
 Minimum window is "BANC".
 */
public class SolutionLXXVI {
    public static String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if(tLen > sLen || tLen * sLen == 0) return "";
        Map<Character, Integer> tMap = buildMap(t);
        int left = 0;
        int right = 0;
        int count = 0;
        String res = "";
        int min = Integer.MAX_VALUE;
        Map<Character, Integer> sMap = new HashMap<Character, Integer>();
        while (right < sLen) {
            char c = s.charAt(right);
            if (tMap.containsKey(c)) {
                if (sMap.containsKey(c)) {
                    if (sMap.get(c) < tMap.get(c)) {
                        sMap.put(c, sMap.get(c)+1);
                        count++;
                    } else {
                        sMap.put(c, sMap.get(c)+1);
                    }
                } else {
                    sMap.put(c, 1);
                    count++;
                }
            }
            // get t as subset
            if (count==tLen) {
                char cs = s.charAt(left);
                while (!sMap.containsKey(cs) || sMap.get(cs) > tMap.get(cs)) {
                    if (sMap.containsKey(cs) && sMap.get(cs) > tMap.get(cs)) {
                        sMap.put(cs, sMap.get(cs)-1);
                    }
                    left++;
                    cs = s.charAt(left);
                }
                if (min > right-left+1) {
                    res = s.substring(left, right+1);
                    min = right-left+1;
                }
            }
            right++;
        }
        return res;
    }
    public static Map<Character, Integer> buildMap(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) map.put(c, 1);
            else map.put(c, map.get(c)+1);
        }
        return map;
    }
}
