import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring
 * T that contains at most 2 distinct characters.

 For example, Given s = “eceba”,
 T is "ece" which its length is 3.
 */
public class SolutionCLIX {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int start = 0;
        int res = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int i;
        for (i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            // remove the left most char in last occurrence
            if (map.size()==2 && !map.containsKey(c)) {
                char charEndsMostLeft = ' ';
                int minLast = s.length();
                for (char ch : map.keySet()) {
                    int last = map.get(ch);
                    if (last < minLast) {
                        minLast = last;
                        charEndsMostLeft = ch;
                    }
                }
                // remove all this chars
                map.remove(charEndsMostLeft);
                start = minLast + 1;
            }
            map.put(c, i); // update the latest char occurence
            res = Math.max(res, i - start + 1);
        }
        return res;
    }
}
