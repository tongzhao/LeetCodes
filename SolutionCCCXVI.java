import java.util.HashMap;
import java.util.Map;

/**
 * Remove Duplicate Letters:
 *
 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once.
 * You must make sure your result is the smallest in lexicographical order among all possible results.

 Example:
 Given "bcabc"
 Return "abc"

 Given "cbacdcbc"
 Return "acdb"
 */
public class SolutionCCCXVI {
    public String removeDuplicateLetters(String s) {
        // 1. find last occurrence index of each letter
        // 2. from the min index to max index, find out the letter which is lexicographically smallest
        if (s==null || s.length()<=1) return s;
        Map<Character, Integer> lastPosMap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) lastPosMap.put(s.charAt(i), i);
        int start = 0;
        int end = findMinLastPos(lastPosMap);
        char[] res = new char[lastPosMap.size()];
        for (int i = 0; i < res.length; i++) {
            char min = 'z'+1;
            for (int k = start; k <= end; k++) {
                if (lastPosMap.containsKey(s.charAt(k)) && s.charAt(k) < min) {
                    min = s.charAt(k);
                    start = k+1;
                }
            }
            res[i] = min;
            if (i==res.length-1) break;

            lastPosMap.remove(min);
            if (s.charAt(end)==min) end = findMinLastPos(lastPosMap);
        }
        return new String(res);
    }
    public int findMinLastPos(Map<Character, Integer> lastPosMap) {
        if (lastPosMap==null || lastPosMap.isEmpty()) return -1;
        int min = Integer.MAX_VALUE;
        for (int index: lastPosMap.values()) min = Math.min(min, index);
        return min;
    }
}
